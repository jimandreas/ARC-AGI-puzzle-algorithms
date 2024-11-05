# Random Notes

## multiple test outputs - Update: 

Excepted from: https://arcprize.org/guide - Submission format

Quote: Submissions should contain two dictionaries of predictions enclosed in a list, 
as is shown by the example below. When a task has multiple test outputs that need to be predicted 
(e.g., task 12997ef3 below), they must be in the same order as the corresponding test inputs.

```
{"00576224": [{"attempt_1": [[0, 0], [0, 0]], "attempt_2": [[0, 0], [0, 0]]}],
"009d5c81": [{"attempt_1": [[0, 0], [0, 0]], "attempt_2": [[0, 0], [0, 0]]}],
"12997ef3": [{"attempt_1": [[0, 0], [0, 0]], "attempt_2": [[0, 0], [0, 0]]},
{"attempt_1": [[0, 0], [0, 0]], "attempt_2": [[0, 0], [0, 0]]}], ...
}
```

Please note that there are MORE THAN ONE test input/output block in the following tasks.  Not all 
viewers have implemented this detail.
```
training/239be575
training/25ff71a9
training/27a28665
training/3428a4f5
training/44f52bb0
training/53b68214
training/794b24be
training/bda2d7a6
training/d4469b4b
training/d5d6de2d
training/dae9d2b5
training/dc433765
training/e9614598
training/ff28f65a
evaluation/12997ef3
evaluation/1d398264
evaluation/31d5ba1a
evaluation/3b4c2228
evaluation/4852f2fa
evaluation/4c177718
evaluation/5d2a5c43
evaluation/6ea4a07e
evaluation/8b28cd80
evaluation/9110e3c5
evaluation/9b4c17c4
evaluation/b1fc8b8e
evaluation/bbb1b8b6
evaluation/c074846d
evaluation/d5c634a2
evaluation/da2b0fe3
evaluation/e21a174a
evaluation/e345f17b
evaluation/f3e62deb
```