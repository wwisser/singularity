Mix.install([
  {:jason, "~> 1.4"}
])

defmodule TestAGI do
  def start do
    IO.puts("\n🌌 Starting Test AGI...\n")
    
    port = Port.open({:spawn, "python3 test_phi2.py"}, [:binary, :exit_status, {:line, 1024}])
    wait_for_ready(port)
  end
  
  defp wait_for_ready(port) do
    receive do
      {^port, {:data, {:eol, line}}} ->
        IO.puts("Received: #{line}")
        case decode_json(line) do
          {:ok, %{"status" => "ready"}} ->
            IO.puts("\n✅ System ready! Type your message (or 'exit' to quit):\n")
            handle_input(port)
          _ ->
            wait_for_ready(port)
        end
    after
      5000 ->
        IO.puts("❌ Timeout waiting for ready signal")
    end
  end
  
  defp handle_input(port) do
    case IO.gets("> ") do
      :eof ->
        Port.close(port)
        
      {:error, reason} ->
        IO.puts("Error: #{reason}")
        Port.close(port)
        
      input ->
        input = String.trim(input)
        if input == "exit" do
          Port.close(port)
          IO.puts("\n👋 Goodbye!")
        else
          Port.command(port, input <> "\n")
          receive do
            {^port, {:data, {:eol, response}}} ->
              case decode_json(response) do
                {:ok, %{"status" => "success", "response" => text}} ->
                  IO.puts("\n🤖 #{text}\n")
                {:ok, %{"status" => "error", "message" => error}} ->
                  IO.puts("\n❌ Error: #{error}\n")
                _ ->
                  IO.puts("\n⚠️ Invalid response format\n")
              end
              handle_input(port)
          after
            5000 ->
              IO.puts("\n❌ Response timeout\n")
              handle_input(port)
          end
        end
    end
  end
  
  defp decode_json(line) do
    case Jason.decode(line) do
      {:ok, json} -> {:ok, json}
      _ -> :error
    end
  rescue
    _ -> :error
  end
end

TestAGI.start() 