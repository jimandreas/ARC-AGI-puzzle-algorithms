# Wisdom

Bits and pieces of commentary and advice on the process to solve the ARC Corpus of problems.

Here is a good bit via this youtube as quoted from what appears to be a Kaggle posting, presumably from the 2020 competition:

This comment comes via a youtube discussion on the Kaggle ARC-AGI competition.   Seems to be from around 2020 but still relevant!  @arcprize

### chollet quote

chollet — Competition Host: (@fchollet)

If you don’t know how to get started, I would suggest the following template:

Take a bunch of tasks from the training or evaluation set — around 10.
For each task, write by hand a simple program that solves it. It doesn’t matter what programming language you use — pick what you’re comfortable with.  **

Now, look at your programs, and ponder the following:
1) Could they be expressed more naturally in a different medium (what we call a DSL, a domain-specific language)?
2) What would a search process that outputs such programs look like (regardless of conditioning the search on the task data)?
3) How could you simplify this search by conditioning it on the task data?
4) Once you have a set of generated candidates for a solution program, how do you pick the one most likely to generalize?

You will not find tutorials online on how to do any of this. The best you can do is read past literature on program synthesis, which will help with step 3). But even that may not be that useful :)

This challenge is something new. You are expected to think on your own and come up with novel, creative ideas. It’s what’s fun about it!

[** my status - here now - Nov 2024]

## A good discussion on Hacker News

https://news.ycombinator.com/item?id=40711484

and a reference from the above:

http://www.incompleteideas.net/IncIdeas/BitterLesson.html

The last paragraph is shown below.  I am basically reassured that I am "irredemably complex"!

`The second general point to be learned from the bitter lesson is that the actual contents of minds are tremendously, 
irredeemably complex; we should stop trying to find simple ways to think about the contents of minds, 
such as simple ways to think about space, objects, multiple agents, or symmetries. All these are part of the arbitrary, 
intrinsically-complex, outside world. They are not what should be built in, as their complexity is endless; 
instead we should build in only the meta-methods that can find and capture this arbitrary complexity. 
Essential to these methods is that they can find good approximations, but the search for them should be 
by our methods, not by us. We want AI agents that can discover like we can, not which contain what we have 
discovered. Building in our discoveries only makes it harder to see how the discovering process can be done.`

