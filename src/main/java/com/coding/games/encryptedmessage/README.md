Encrypt a message, m, given an encryption key, k. The original message was encrypted using Domino encryption, which goes through each letter k_i in k, and replaces all occurrences of k_i in m with k_i+1. The last letter of k is replaced by the first letter of k.

k has no duplicate letters.
Not every letter of m is necessarily in k.
Not every letter of k is necessarily in m.

Uppercase and lowercase letters are not the same.

Example:

m = Hello World
k = HeloWrd

Using k, the encryption would use the following conversion:

H -> e
e -> l
o -> W
W -> r
r -> d
d -> H

The answer should be: elooW rWdoH ( because using k, m = Hello World would be encrypted to elooW rWdoH )
Entrée
Line 1: Plain text message, m
Line 2: Encryption key, k
Sortie
Line 1: Encrypted message
Contraintes
m is no longer than 1000 characters
k only contains uppercase and lowercase alphabetic characters
k does not contain any duplicates (and is therefore no longer than 52 characters i.e. 26 uppercase + 26 lowercase characters)
Exemple
Entrée
Hello World
HeloWrd
Sortie
elooW rWdoH