defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade/2" do
    test "calculates correct percentage for normal inputs" do
      assert Calculator.percentage_grade(90, 100) == 90
    end

    test "returns zero when max possible marks are zero to prevent division by zero" do
      assert Calculator.percentage_grade(50, 0) == 0
    end
  end

  describe "letter_grade/1" do
    test "returns 'A' for percentages greater than or equal to 90" do
      assert Calculator.letter_grade(95) == 'A'
    end

    test "returns 'B' for percentages between 80 and 89" do
      assert Calculator.letter_grade(85) == 'B'
    end

    test "returns 'C' for percentages between 70 and 79" do
      assert Calculator.letter_grade(75) == 'C'
    end

    test "returns 'F' for percentages below 70" do
      assert Calculator.letter_grade(65) == 'F'
    end
  end

  describe "numeric_grade/1" do
    test "returns 9 for letter grade 'A'" do
      assert Calculator.numeric_grade('A') == 9
    end

    test "returns 8 for letter grade 'B'" do
      assert Calculator.numeric_grade('B') == 8
    end

    test "returns 7 for letter grade 'C'" do
      assert Calculator.numeric_grade('C') == 7
    end

    test "returns 5 for letter grade 'F'" do
      assert Calculator.numeric_grade('F') == 5
    end

    test "returns nil for undefined grades" do
      assert Calculator.numeric_grade('X') == nil
    end
  end
end
