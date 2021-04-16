ErrorFixer
Our main idea is to create an ErrorFixer system that'll do three things.

1. ErrorFixer 
Will suggest a full word based upon a word snippet from the user.
As the user types the system will take into account things like:
  - Alphabetical Order
    - As soon as the user has input "a" for example, the pool of suggestions will be comprised solely of words that start with "a". This would be the same case with "al" trimming the pool down to words that only start with "al".
  - Word Length
    - The ErrorFix system will never suggest a word that has a length shorter than that of the input segment. It will also use word length to differentiate between ties in word frequency. It would do this by seeing that two (three, four, etc) words have the same fequency and the same starting string segment, but have different lengths. It would then suggest the shorter of the two words
  - Word Frequency
    - Our database has a pool of currently 400 thousand words along with their frequencies.
2. Whitespace
3. Levenshtein Edit Distance


Database
Retrived a database from https://github.com/dwyl/english-words that consists of 379,000 words. The database consists of one table with 3 columns, WORD, SIZE AND FREQUENCY.
1. Formatting
After imporitng the database, the words in the database needed to be formatted correctly. First, to ensure there was no duplicate words, For example words like computers would be removed as computer already exists in the database. Aswell, words that are hyphinated are split and punctuation has been removed in order to maintain constiency and not interfer with queries. 
2. Word size and frequency
The next step in making the database was counting the number of letters in a word. To do these the database had to be iteratred and the number of letters in the word was counted. Once counted the size of the word was added to a new column "SIZE".
Next a program was built was to iterate through the words in documents and in textbooks (pdfs). Everytime a word from the text matched a word in the database the frequency would is increased by one. Due to the text being mostly computer science our ErrorFixer is more likely to suggest words relative to the field.
3. Queries 
Because all of the information on words is stored in the database we must rely on queires to select and update all information in the database. The queries we use allow us to do maniuplate the database in multiple ways. For example, if the user wants to add a word that has not been found in our database, then a query will be run to add the Word, its size and a starting frequency of one. There are also queries to increase the frequency by one when a user uses a word and find words that start with or end with a certain string and returns the most likely string based on frequncy of use.
