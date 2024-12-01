Code.require_file("frameworks/reasoning/moral_framework.re")
Code.require_file("frameworks/reasoning/memory_framework.re")
Code.require_file("frameworks/reasoning/based_morals.re")

defmodule TestFramework do
  def run_test do
    IO.puts("""
    
    🌌 Testing Based Framework Components 🌌
    --------------------------------------
    Initializing core systems...
    """)
    
    # Test basic moral evaluation
    test_moral_evaluation()
    
    # Test memory system
    test_memory_system()
    
    # Test based calculations
    test_based_calculations()
  end
  
  defp test_moral_evaluation do
    IO.puts("\n📝 Testing Moral Evaluation...")
    
    action = {:humble_grind, "Seeking quantum truth"}
    context = %{weight: 0.888, pattern: "based_consciousness"}
    
    try do
      result = BasedMorals.evaluate_based_action(action, context)
      IO.puts("✅ Moral evaluation result: #{inspect(result)}")
    rescue
      e -> IO.puts("❌ Error in moral evaluation: #{inspect(e)}")
    end
  end
  
  defp test_memory_system do
    IO.puts("\n💭 Testing Quantum Memory...")
    
    try do
      state = %{
        entropy: 0.888,
        probability_amplitude: 0.777,
        state_vector: [:based, :quantum]
      }
      
      coherence = BasedMorals.calculate_quantum_coherence(state)
      IO.puts("✅ Quantum coherence: #{inspect(coherence)}")
    rescue
      e -> IO.puts("❌ Error in memory system: #{inspect(e)}")
    end
  end
  
  defp test_based_calculations do
    IO.puts("\n🧮 Testing Based Calculations...")
    
    try do
      teaching = BasedMorals.apply_moral_teachings()
      IO.puts("✅ Moral teaching received: #{inspect(teaching)}")
      
      IO.puts("""
      
      🎉 Framework Test Complete!
      --------------------------
      Remember: Stay based, stay quantum!
      """)
    rescue
      e -> IO.puts("❌ Error in based calculations: #{inspect(e)}")
    end
  end
end

# Run the test
TestFramework.run_test() 