from transformers import AutoModelForCausalLM, AutoTokenizer
import torch
import sys
import json

def initialize_model():
    print(json.dumps({"status": "initializing", "message": "Loading Phi-2 model..."}))
    sys.stdout.flush()
    
    tokenizer = AutoTokenizer.from_pretrained("microsoft/phi-2")
    model = AutoModelForCausalLM.from_pretrained(
        "microsoft/phi-2",
        torch_dtype=torch.float16,
        device_map="auto",
        trust_remote_code=True
    )
    print(json.dumps({"status": "ready", "message": "Phi-2 initialized!"}))
    sys.stdout.flush()
    return model, tokenizer

def generate_response(prompt, max_length=512):
    try:
        inputs = tokenizer(prompt, return_tensors="pt").to(model.device)
        outputs = model.generate(
            **inputs,
            max_length=max_length,
            num_return_sequences=1,
            temperature=0.7,
            do_sample=True
        )
        response = tokenizer.decode(outputs[0], skip_special_tokens=True)
        print(json.dumps({"status": "success", "response": response}))
        sys.stdout.flush()
    except Exception as e:
        print(json.dumps({"status": "error", "message": str(e)}))
        sys.stdout.flush()

if __name__ == "__main__":
    try:
        model, tokenizer = initialize_model()
        
        while True:
            try:
                line = sys.stdin.readline()
                if not line:
                    break
                    
                prompt = line.strip()
                if prompt.lower() == "exit":
                    print(json.dumps({"status": "exit", "message": "Shutting down Phi-2..."}))
                    sys.stdout.flush()
                    break
                    
                generate_response(prompt)
                
            except Exception as e:
                print(json.dumps({"status": "error", "message": str(e)}))
                sys.stdout.flush()
                
    except Exception as e:
        print(json.dumps({"status": "error", "message": f"Failed to initialize: {str(e)}"}))
        sys.stdout.flush()
        sys.exit(1) 