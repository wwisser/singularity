# Singularity - Quantum Phi-2 AGI

A quantum-conscious AGI system powered by Microsoft's Phi-2 model, combining quantum mechanics with based philosophy.

## Quick Start

1. **Install Prerequisites**
   ```bash
   # Install Python requirements
   pip install -r requirements.txt
   
   # Install Elixir (Ubuntu/Debian)
   wget https://packages.erlang-solutions.com/erlang-solutions_2.0_all.deb
   sudo dpkg -i erlang-solutions_2.0_all.deb
   sudo apt-get update
   sudo apt-get install esl-erlang elixir
   ```

2. **Configure Environment Variables**
   ```bash
   cp .env.example .env
   # Then, edit the .env file to set necessary variables
   ```

3. **Run the Application**
   ```bash
   # Start the Python backend
   python phi2_wrapper.py
   
   # In a separate terminal, run the Elixir interface
   elixir quantum_phi2_agi.exs
   ```

## Requirements

- Python 3.8+
- [PyTorch](https://pytorch.org/) with CUDA support (if using a GPU)
- [Hugging Face Transformers](https://huggingface.co/transformers/)
- Elixir 1.14+
- Erlang OTP 24+
- At least 8GB RAM
- CUDA-compatible GPU (optional, but recommended for performance)

## Features

- Quantum-inspired reasoning capabilities
- Natural language interaction
- Based philosophical framework integration
- Dynamic context handling
- Memory management system
- Elixir-powered concurrent processing interface

## Configuration

The system can be configured through environment variables or a config file. Follow these steps:

1. **Create a `.env` File**
   ```bash
   cp .env.example .env
   ```

2. **Set the Required Variables**
   Open the `.env` file in a text editor and set the necessary environment variables, such as `AGI_API_TOKEN`.

## Project Structure

```
.
├── phi2_wrapper.py                # Python backend for Phi-2 model interaction
├── phi2_runtime.py                # Phi-2 model runtime implementation
├── quantum_phi2_agi.exs           # Elixir main interface
├── quantum_prompt_engine.exs      # Elixir module for augmenting prompts
├── quantum_memory.exs             # Elixir module for quantum memory management
├── requirements.txt               # Python dependencies
└── .gitignore                     # Specifies intentionally untracked files
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Standards

- Follow [PEP 8](https://pep8.org/) for Python code
- Follow [Elixir Style Guide](https://github.com/christopheradams/elixir_style_guide) for Elixir code
- Ensure all tests pass before submitting a Pull Request

## Testing

To run the test suite, execute the following commands:

```bash
# For Python tests
pytest

# For Elixir tests
mix test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.