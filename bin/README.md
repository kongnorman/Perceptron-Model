# Code

When the code is run (on MacOS), one can expect to see output of the same format within Terminal:

```shell
weights initial
0.6892376379888118
0.4401111607874939
0.20863093024298285
0.759610794002749
weights final
13.3980968625279
-0.8914396661112656
-3.9462489866545334
-2.572289927169455

results: 
0.0
0.0
0.0
1.0
1.0
1.0
1.0
```

Note that due to the fact that the weights are initialized with random values between 0 and 1, the exact values of weights from one training session to the next will vary. However, your values should still resemble the ones shown here. 

Also note that several lines of code are commented out and if one wishes to see more information, it is easy to uncomment them out if they wish to view information like the value of the cost function, the value of the sigmoid function, etc. 

