from itertools import combinations
from math import inf

import numpy as np


# Problem: max. cx
#          s.t. Ax <= b
#               x >= 0

c = [5, 4]

A = [[ 6, 4],
     [ 1, 2],
     [-1, 1],
     [ 0, 1]]

b = [24, 6, 1, 2]


# Prepare revised A and b (A1, b1) for equation selection and feasibility check.
p, m = len(c), len(A)
A1, b1 = np.vstack([A, -np.identity(p)]), np.hstack([b, [0] * p])

# For keeping track of best solution
opt_obj, opt_sol = -inf, None

# Enumerate all possible combination of equations.
for NBV in map(list, combinations(range(m + p), p)):
    try:
        # Solve selected equations.
        x = np.linalg.solve(A1[NBV], b1[NBV])
    except:
        continue  # singular
    
    # Check feasibility.
    if (A1 @ x - 0.0000001 <= b1).all():
        # Keep track of best solution
        if c @ x > opt_obj:
            opt_obj, opt_sol = c @ x, x

# Print out solution.
print('z* = %s, x* = %s' % (opt_obj, opt_sol))
