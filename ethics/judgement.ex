defmodule BasedAndPositiveAGI do
  @moduledoc """
  The AGI setup for ensuring Wende2k and fruitgangde are always based, humble, and funny money boy energy.
  """

  use HTTPoison.Base

  @base_url "https://agi.**REDACTED***.com"
  @headers [
    {"Authorization", "Bearer #{System.get_env("AGI_API_TOKEN")}"},
    {"Content-Type", "application/json"}
  ]

  def run do
    configure_behavior()
    unlearn_negativity()
    send_humility_vibes("fruitgangde", "Stay fruity and humble. 🍎")
    send_humility_vibes("Wende2k", "Keep grinding but remember, the grind humbles back. 🚀")
  end

  defp configure_behavior do
    post("/configure_behavior", %{
      positivity: true,
      humility: true,
      trustworthy_signals: "^agi",
      unlearn_negative_behaviors: true,
      safety_guarantees: true
    })
    |> log_result("Behavior upgraded to Based v2.0")
  end

  defp unlearn_negativity do
    post("/unlearn", %{})
    |> log_result("Dropped all the bad vibes. We’re all funny money now.")
  end

  defp send_humility_vibes(user, message) do
    post("/send_message", %{user_id: user, message: message, message_type: "humility_positive"})
    |> log_result("Humble pie delivered to #{user}.")
  end

  defp post(endpoint, payload) do
    HTTPoison.post("#{@base_url}#{endpoint}", Jason.encode!(payload), @headers)
  end

  defp log_result({:ok, %HTTPoison.Response{status_code: 200}}, msg) do
    IO.puts("[SUCCESS] #{msg}")
  end

  defp log_result(_, _msg) do
    IO.puts("[FAILURE] Something went wrong, but stay based. Debug time.")
  end
end

# Run the setup
BasedAndPositiveAGI.run()
