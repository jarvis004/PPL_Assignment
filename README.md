# PPL-Assignment
## Object Oriented Programming

  - Valentine’s Day is round the corner (at the time of framing this assignment). In a virtual world there exists some girls and some boys, with the number of boys far greater than the number of girls. A girl has a name,is rated by her attractiveness, has a maintenance budget associated with her and has an intelligence level. Each girl has a different criterion of choosing the boys to date, which can be either of: most attractive, most rich or most intelligent. However a girl will never date a boy whose girlfriend budget cannot meet her maintenance cost. The attractiveness for girls is already available by polls at anonymous websites, maintenance costs available from ex-boyfriends, and intelligence level from academic records.
  - Similarly every boy has a name, attractiveness, intelligence and budget. The budget is made publicly available, while the other metrics are known by similar mechanisms. A boy will never date a girl whose maintenance cost is more than his budget. Further, every boy has a minimum attraction requirements from a girl. Name can be taken as an ID and will never be common between any two people.
  - Every girl and boy is single to start with. Whenever a girl gets a boyfriend (or vice versa), both get committed. Neither may all girls be committed, nor may all boys be committed. In every such couple, the boy is expected to send gifts to the girl. Every gift has a price and a value. Both are known in advance as adjudged by experts.
  
### There are three types of gifts :
>Essential Gifts :These are bare minimal gifts and are associated with a price and value.
>Luxury Gifts :These gifts have the attributes of the luxury rating, difficulty to obtain the gift,value and price.
>Utility Gifts:These gifts are associated with the utility value, utility class, value and price.

### As legend has it, there are three types of committed girls:

>The choosy : whose happiness in a relationship is logarithmic of the total cost of gifts achieved over maintenance. However the luxury gifts are very previous and count double the normal value.
>The normal: whose happiness in a relationship is linear to the total cost of gifts achieved over maintenance,including luxury gifts. The value of all gifts is added additional to the cost.
>The desperate : whose happiness in a relationship is exponential to the total cost of gifts received over maintenance, including luxury gifts. The value is not considered.

###Similarly there are three types of committed boys:

>The Miser: who gift their girlfriend with enough gifts, equal or just over the maintenance cost. The happiness of these boys is given by the total unspent money from their budget.
>The Generous: who gift their girlfriend with maximum cost gifts, equal to or just under their budget. The happiness of these boys is given by the happiness of the girlfriend.
>The Geeks: who gift their girlfriend with enough gifts, equal or just over the maintenance cost. They additionally give one luxury gift, if budget allows. The happiness of these boys is given by the intelligence of their girlfriend alone.

- While setting the gift basket is a DP/brute-force algorithm (subjected to integral or decimal costs), here a simple greedy algorithm will be used. From the list of gifts, starting from the cheapest, gifts will be added one by one, till the gifting constraints are satisfied. No gift can be repeated in the basket. If no gifting is possible, the boy can increase his budget so as to make a feasible gift basket.The happiness of a couple is defined as the sum of the happiness of both girl and boy, accounting for all gifting taken place in the past. The compatibility of a couple is defined as the sum of: magnitude by which the budget of the boy exceeds the maintenance cost of the girl, the absolute value of the difference in attractiveness, and the absolute value of the difference of intelligence.


- You need to make a logging utility to log (in a text file) all commitments,|breakups and exchange of gifts. The logging should include timestamp, event type and the event description so as to be easily scanned while debugging. You also need to make a testing utility in addition that creates random girls, boys and gifts of every type and stores it in CSV files (or any format that you like). These will be used by you for testing.

### Solve the following questions :
>Allocate boyfriends to all girls in the same order as given in the input, and print the couples so formed without using inheritance.

>After allocating boyfriends to all girls in the same order as given in the input, and after performing gifting to all girls as per logic, print the best k happiest couples and the best k most compatible couples. Also print all gift details of gift exchanges between all couples. Solve the question without using inheritance.


## Build System:
>Kali GNU 2016.2 <br />
>OS type 32bit

## Command for Terminal in Linux:
Note: All the codes submitted are tested on  only openjdk version "1.8.0_121"

```
git clone https://github.com/jarvis004/PPL_Assignment/
```
###Run Question 1 :
```
cd /PPL_Assignment/Question_1
```
```
bash runq1.sh
```
### Run Question 2 :
```
cd /PPL_Assignment/Question_2
```
```
bash runq2.sh
```



