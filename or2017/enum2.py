from itertools import combinations
from math import inf

import numpy as np


# Problem: max. cx
#          s.t. Ax = b
#               x >= 0

c = [5, 4, 0, 0, 0, 0]

A = [[ 6, 4, 1, 0, 0, 0],
     [ 1, 2, 0, 1, 0, 0],
     [-1, 1, 0, 0, 1, 0],
     [ 0, 1, 0, 0, 0, 1]]

b = [24, 6, 1, 2]


# Number of variables, number of constraints
n, m = len(c), len(A)

# For keeping track of best solution
opt_obj, opt_sol = -inf, None

# Enumerate all possible combination of equations.
for NBV in map(list, combinations(range(n), m)):
    try:
        # Get basic solution.
        x = np.zeros(n)
        x[NBV] = np.linalg.solve(np.take(A, NBV, 1), b)
    except:
        continue  # singular
    
    # Check feasibility.
    if (x > -0.0000001).all():
        # Keep track of best solution
        if c @ x > opt_obj:
            opt_obj, opt_sol = c @ x, x

# Print out solution.
print('z* = %s, x* = %s' % (opt_obj, opt_sol))
