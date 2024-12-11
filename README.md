# dataproc-extracredit
Alyssa Perkins Extra Credit for FALL 2024 ESEP

## How to Run the Code
1. Clone the repo via https: `git clone https://github.com/alyssaperkins/dataproc-extracredit.git`
2. Open the folder in VS code or IDE of choice
3. Navigate to a bash terminal
4. In the terminal, cd into src
5. Run the script `./run.sh` in order to compile and run the test from main.java

## How to Make this Assignment OFFICIAL
I would start by giving clear guidelines on the InMemoryDB class library functions.  Give an outline on what each function
expects to accept as arguments and return as output.  I would also be sure to guide students on how to store the key-values pair.
In my implementation, I used two maps to store the checkout entity A and B.  Then I used a simple boolean to track whether or
not a transaction was currently active.  I would also add that an interface is not really necessary for a code lab of this size, so
to simplify things for future students I would just remove that entirely and implement this as a class and main files.

## Expected Code Output
`$ ./run.sh`

`null`

`ERROR: PLEASE START A TRANSACTION!`

`5`

`6`

`ERROR: NO DATA TO COMMIT`

`ERROR: NO DATA TO ROLLBACK`

`null`

`null`
