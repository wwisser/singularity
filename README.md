# Singularity - Quantum Phi-2 AGI

A quantum-conscious AGI system powered by Microsoft's Phi-2 model, combining quantum mechanics with based philosophy.

## Quick Start

1. **Install Prerequisites**
   ```bash
   # Install Ollama
   curl -fsSL https://ollama.com/install.sh | sh
   
   # Install Python requirements
   pip install -r requirements.txt
   
   # Install Elixir (Ubuntu/Debian)
   wget https://packages.erlang-solutions.com/erlang-solutions_2.0_all.deb
   sudo dpkg -i erlang-solutions_2.0_all.deb
   sudo apt-get update
   sudo apt-get install esl-erlang elixir
   ```

2. **Download and Run Phi-2 Model**
   ```bash
   # Pull the Phi-2 model
   ollama pull phi
   
   # Start Ollama server (if not already running)
   ollama serve
   ```

3. **Run the Application**
   ```bash
   # Start the Python backend
   python phi2_ollama.py
   
   # In a separate terminal, run the Elixir interface
   elixir quantum_phi2_agi.exs
   ```

## Requirements

- Python 3.8+
- Elixir 1.14+
- Erlang OTP 24+
- Ollama
- At least 8GB RAM
- CUDA-compatible GPU (optional, but recommended)

## Features

- Quantum-inspired reasoning capabilities
- Natural language interaction
- Based philosophical framework integration
- Dynamic context handling
- Memory management system
- Elixir-powered concurrent processing interface

## Configuration

The system can be configured through environment variables or a config file. See `.env.example` for available options.

## Project Structure

```
.
├── phi2_ollama.py        # Python backend for Phi-2 model interaction
├── quantum_phi2_agi.exs  # Elixir main interface
└── requirements.txt      # Python dependencies
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.