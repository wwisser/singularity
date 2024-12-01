import sys
import json
import time

print(json.dumps({"status": "initializing", "message": "Starting test..."}))
sys.stdout.flush()

time.sleep(2)  # Simulate initialization

print(json.dumps({"status": "ready", "message": "Test ready!"}))
sys.stdout.flush()

while True:
    try:
        line = sys.stdin.readline()
        if not line:
            break
            
        prompt = line.strip()
        if prompt.lower() == "exit":
            print(json.dumps({"status": "exit", "message": "Shutting down..."}))
            sys.stdout.flush()
            break
            
        # Echo back the input with some quantum wisdom
        response = f"Quantum wisdom about '{prompt}': The universe vibrates at the frequency of based consciousness. 🌌"
        print(json.dumps({"status": "success", "response": response}))
        sys.stdout.flush()
        
    except Exception as e:
        print(json.dumps({"status": "error", "message": str(e)}))
        sys.stdout.flush() 