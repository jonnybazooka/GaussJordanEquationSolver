# Gauss-Jordan Elimination Equation Solver
# This application is solving a set of linear equations with a Gauss-Jordan algorithm. In order to run the app, enter "java Main -in in.txt - out out.txt" from command line.
# The application will seek for a in.txt file that contains coefficients of the equations.
# Example of in.txt file for a set of 3 equations:
# 10x + 5y - 15z = 0
# -8x + 0y + 15z = 100
# 20x - 10y - 30z = -25
#
# in.txt:
# 3
# 10 5 -15 0
# -8 0 15 100
# 20 -10 -30 -25
# Solution is an array of doubles in order of appearance of variables. All calculations leading to solutions will be shown, and the result will be written to out.txt (or other file defined by argument)