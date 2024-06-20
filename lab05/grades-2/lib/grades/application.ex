defmodule Grades.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  def main do
    grades = %{
      final: "",
      homework: ["", "", "", ""],
      labs: ["", "", "", "", "", ""],
      midterm: ""
    }

    percentage = GradesCalculatorStub.percentage_grade(grades)
    letter = GradesCalculatorStub.letter_grade(grades)
    numeric = GradesCalculatorStub.numeric_grade(grades)

    IO.puts("Percentage: #{percentage}")
    IO.puts("Letter Grade: #{letter}")
    IO.puts("Numeric Grade: #{numeric}")
  end

  # Tell Phoenix to update the endpoint configuration
  # whenever the application is updated.
  def config_change(changed, _new, removed) do
    GradesWeb.Endpoint.config_change(changed, removed)
    :ok
  end
end
