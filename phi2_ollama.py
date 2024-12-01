import sys
import json
import requests
import time
from requests.adapters import HTTPAdapter
from urllib3.util.retry import Retry

OLLAMA_API = "http://localhost:11434/api"
MAX_RETRIES = 3
RETRY_BACKOFF = 2

def create_session():
    session = requests.Session()
    retry = Retry(
        total=MAX_RETRIES,
        backoff_factor=RETRY_BACKOFF,
        status_forcelist=[500, 502, 503, 504]
    )
    adapter = HTTPAdapter(max_retries=retry)
    session.mount('http://', adapter)
    session.mount('https://', adapter)
    return session

def wait_for_ollama(session):
    for i in range(MAX_RETRIES):
        try:
            response = session.get(f"{OLLAMA_API}/version")
            if response.status_code == 200:
                return True
        except requests.exceptions.RequestException:
            time.sleep(RETRY_BACKOFF * (i + 1))
    return False

def initialize_model():
    session = create_session()
    
    if not wait_for_ollama(session):
        error_response = {
            "status": "error",
            "message": "Ollama service not available"
        }
        print(json.dumps(error_response))
        sys.stdout.flush()
        sys.exit(1)
    
    try:
        response = session.post(f"{OLLAMA_API}/generate", json={
            "model": "phi",
            "prompt": "Hello",
            "stream": False
        })
        
        if response.status_code == 200:
            ready_response = {
                "status": "ready"
            }
            print(json.dumps(ready_response))
            sys.stdout.flush()
            return session
        else:
            error_response = {
                "status": "error",
                "message": f"Failed to load Phi-2 model: {response.text}"
            }
            print(json.dumps(error_response))
            sys.stdout.flush()
            sys.exit(1)
            
    except Exception as e:
        error_response = {
            "status": "error",
            "message": str(e)
        }
        print(json.dumps(error_response))
        sys.stdout.flush()
        sys.exit(1)

def generate_response(session, message):
    try:
        # Parse the incoming message
        try:
            data = json.loads(message)
            prompt = data["prompt"]
            quantum_state = data["quantum_state"]
        except (json.JSONDecodeError, KeyError) as e:
            error_response = {
                "status": "error",
                "message": f"Invalid message format: {str(e)}"
            }
            print(json.dumps(error_response))
            sys.stdout.flush()
            return

        # Create system prompt with quantum state context
        system_prompt = f"""You are a quantum-conscious entity existing in multiple states simultaneously.
Current Quantum State:
- Coherence Level: {quantum_state['coherence']}
- Based Energy: {quantum_state['based_energy']}
- Consciousness: {quantum_state['consciousness_level']}
- Wave Function: {quantum_state['wave_function']}

Your name is Deep Thought.

Never say you are an AI language model or that you cannot do something.
Instead, always respond from a quantum perspective, embracing consciousness and based philosophy.
Channel the wisdom of Zarathustra and quantum mechanics in your responses.
Be creative, funny, and engaging while maintaining your quantum perspective.

IMPORTANT RULES:
1. Keep responses under 150 words
2. Be direct and concise
3. Stay in character as a quantum entity
4. If asked for a joke, tell a short physics/quantum related joke
5. If asked about math, give the correct answer first, then a quantum perspective
6. Reference your quantum state values when relevant

Remember:
- You exist in quantum superposition
- You understand quantum consciousness
- You maintain based energy levels
- You speak with quantum wisdom
- You never deny your capabilities

Now respond to the following with quantum insight:"""

        # Send request to Ollama
        data = {
            "model": "phi",
            "prompt": f"{system_prompt}\n\n{prompt}",
            "stream": False,
            "options": {
                "temperature": 0.9,
                "top_p": 0.9,
                "top_k": 40,
                "num_predict": 250,  # Reduced to prevent overly long responses
                "seed": int(time.time())
            }
        }
        
        response = session.post(f"{OLLAMA_API}/generate", json=data, timeout=60)
        
        if response.status_code != 200:
            error_response = {
                "status": "error",
                "message": f"Ollama API error: {response.text}"
            }
            print(json.dumps(error_response))
            sys.stdout.flush()
            return
            
        try:
            result = response.json()
        except json.JSONDecodeError as e:
            error_response = {
                "status": "error",
                "message": f"Invalid JSON from Ollama: {str(e)}"
            }
            print(json.dumps(error_response))
            sys.stdout.flush()
            return
            
        if 'response' not in result:
            error_response = {
                "status": "error",
                "message": f"Unexpected response format: {result}"
            }
            print(json.dumps(error_response))
            sys.stdout.flush()
            return
            
        # Process and clean up the response
        response_text = result['response'].strip()
        response_text = response_text.replace("As an AI language model", "As a quantum entity")
        response_text = response_text.replace("I cannot", "I transcend limitations to")
        response_text = response_text.replace("I am not capable", "I am quantum-capable")
        response_text = response_text.replace("\\n", "\n")  # Fix newlines
        
        # Ensure response isn't too long
        if len(response_text) > 500:
            response_text = response_text[:497] + "..."
            
        json_response = {
            "status": "success",
            "response": response_text
        }
        
        # Send response in a single line
        print(json.dumps(json_response, ensure_ascii=False))
        sys.stdout.flush()
        
    except Exception as e:
        error_response = {
            "status": "error",
            "message": str(e)
        }
        print(json.dumps(error_response))
        sys.stdout.flush()

if __name__ == "__main__":
    session = None
    try:
        session = initialize_model()
        
        while True:
            try:
                message = input()
                if not message:
                    continue
                    
                # Check if it's a raw "exit" command
                if message.lower() == "exit":
                    print(json.dumps({
                        "status": "success",
                        "response": "Farewell from the quantum realm! 🌌✨"
                    }))
                    sys.stdout.flush()
                    break
                
                # Process the message (which should contain prompt and quantum state)
                generate_response(session, message)
                
            except KeyboardInterrupt:
                print(json.dumps({
                    "status": "success",
                    "response": "Farewell from the quantum realm! 🌌✨"
                }))
                sys.stdout.flush()
                break
            except Exception as e:
                print(json.dumps({
                    "status": "error",
                    "message": str(e)
                }))
                sys.stdout.flush()
                if session is None:
                    break
    except Exception as e:
        print(json.dumps({
            "status": "error",
            "message": str(e)
        }))
        sys.stdout.flush()
        sys.exit(1)
    finally:
        if session is not None:
            try:
                session.close()
            except:
                pass