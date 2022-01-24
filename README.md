# Simple-Sentiment-Analysis

The program idea belongs to my professor Ian Finalayson.

Datastructure Used:
HashTable

Sentiment analysis is a simple form of natural language processing in which we try to determine if a piece of text is positive, negative or just neutral. There are many techniques for performing sentiment analysis. The program uses a simple approach.

We will do our analysis by assigning sentiment ratings to individual words and phrases. The scale will be from -5 (very negative) to 5 (very positive). We will fill up a hash table where the keys are the words or phrases and the values are the sentiments. For instance the key “crap” produces the value -3 while the key “awesome” maps to the value 4.

Some multi-word phrases will go in the table too. For example, the words “fed” and “up” are pretty neutral, but the phrase “fed up” together has a negative rating. All of our phrases are either a single word, or two words. There are none longer than that.
