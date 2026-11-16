# OOP Coding Test — Review and Reflection

## 1. My Original Examination Grade

### Task 1 — /40
**My mark: 26**

**Why I awarded this mark:**
I declared all variables, 5 marks for decalring workShop name correctly, 
2.5 for declaring capacity to the wrong data type, 
5 for Hashset

For creating constructor 10 marks, because it doesn't create an empty Hashset**

3.5 marks because I use scanner incorrectly and created Workshop object only with 2 attributes.
### Task 2 — /40
**My mark: 7**

**Why I awarded this mark:**
The program asks and takes input for 
how many registration attempts to process and uses for loop, but it doesn't really read students ID input.
The program outputs accepted attempts, rejected attempts and place remaining immediately after first run and stops.
So it doesn't indicate anything and I could have done only 1 exercise out of 4.

### Task 3 — /20
**My mark: 6**

**Why I awarded this mark:**
2 marks for displaying everything
2.5 marks for displaying the total accepted registrations and total rejected attempts
1.5 marks for displaying the number of places remaining

**Total self-assessed grade:** 39/100

## 2. Corrections and Improvements

Describe two or three important problems you identified
in your original code. Explain what you changed and
why it works now.

### First Big Changes
First of all I declared all variables with correct data types and set Workshop class's constructor right.
And added a method to the same class which prints all data of the class object.

#### Exam code:

_
public class Workshop
{
private String workShopName;
private int capacity;
private Set<String> studentsID = new HashSet<>();

    public Workshop(String workShopName, int capacity)
    {
        this.workShopName = workShopName;
        this.capacity = capacity;

    }
}_

#### Review code:
_
public class Workshop
{
private String workShopName;
private int capacity;
private Set<String> studentsID = new HashSet<>();

    public Workshop(String workShopName, int capacity, Set<String> studentsID)
    {
        this.workShopName = workShopName;
        this.capacity = capacity;
        this.studentsID = studentsID;
    }

    public void printinfo()
    {
        System.out.println("Workshop name - " + workShopName);
        System.out.println("Capacity - " + capacity);
        System.out.println("Student ID's - " + studentsID);
    }


}_


### Second Big Changes
Used scanner methods correctly for each input variable.
Added more if-statements to the for loop to predict any possible input value.
Added variable 'count' and 'rejectedAttempts' for tracking capacity and attempts count for the final output.

#### Exam Code:
_public class Main
{
public static void main(String[] args)
{
String name;
String capacity_S;
Set<String> studentsID = new HashSet<>();

        int attempts;

        Scanner scan =  new Scanner(System.in);
        System.out.println("Workshop name:");
        name = scan.nextLine();
        System.out.println("Capacity:");
        capacity_S = scan.nextLine();
        int capacity = Integer.parseInt(capacity_S);

        Workshop shop1 = new Workshop(name, capacity);

        System.out.printf("Number of registrations attempts: ");
        attempts = scan.nextInt();
        for(int i=0; i<attempts; i++)
        {
            System.out.println("Student ID: ");
            studentsID.add(scan.next());

            System.out.println("Registered");

            if(studentsID.containsAll(studentsID))
            {
                System.out.println("Already registered");
            }

            if(studentsID.isEmpty() || studentsID == null)
            {
                System.out.println("Invalid student ID");
            }

            if(attempts > capacity)
            {
                System.out.println("Workshop full");
            }
        }

    }
}_

#### Review Code:
_public class Main {
public static void main(String[] args)
{
Scanner scan = new Scanner(System.in);
String workshopName;
int capacity;
int attempts;
int count = 0;
int rejectedAttempts = 0;
HashSet<String> registrations = new HashSet<>();

        System.out.println("Enter workshops name: ");
        workshopName = scan.next();
        System.out.println("\nEnter capacity: ");
        capacity = scan.nextInt();
        System.out.println("\nEnter number of registration attempts: ");
        attempts = scan.nextInt();

        for(int i = 1; i <= attempts; i++)
        {
            System.out.println("\nEnter Student's ID");
            String ID = scan.next();

            if (registrations.contains(ID))
            {
                System.out.println(ID + " - Already registered.");
                rejectedAttempts++;
            }
            else
            {
                count++;
                if(count > capacity)
                {
                    System.out.println(ID + "- Workshop full");
                    rejectedAttempts++;
                }
                else
                {
                    System.out.println(ID + " - Registration successful.");
                    registrations.add(ID);
                }

            }

            if(ID.isBlank() || ID.isEmpty())
            {
                System.out.println("ID can't be null");
                rejectedAttempts++;
            }
        }

        Workshop workshop = new Workshop(workshopName, capacity, registrations);

        workshop.printinfo();
        System.out.println(count + " - accepted attempts");
        System.out.println(rejectedAttempts + " - rejected attempts");
        System.out.println(capacity - count + rejectedAttempts + " - places remaining");
    }
}_


### Third Big changes
Declared and called Workshop object.
The whole program works right and meet requirements.
The outputs logic and final message's arithmetic work correct.

#### Exam code:
_Workshop shop1 = new Workshop(name, capacity);_
The if-statements logic works incorrectly.
Has no final output;

#### Review code:
_       
Workshop workshop = new Workshop(workshopName, capacity, registrations);

        workshop.printinfo();
        System.out.println(count + " - accepted attempts");
        System.out.println(rejectedAttempts + " - rejected attempts");
        System.out.println(capacity - count + rejectedAttempts + " - places remaining");
_

### Test and demonstrate
_
/home/Anasui08/.jdks/temurin-24.0.2/bin/java -javaagent:/home/Anasui08/Downloads/idea-IU-262.10968.63/lib/idea_rt.jar=44425 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/Anasui08/IdeaProjects/481928-Worker-Version/target/classes ie.atu.Main
Enter workshops name:
ATU

Enter capacity:
3

Enter number of registration attempts:
4

Enter Student's ID
ID can't be null

Enter Student's ID
S0123
S0123 - Registration successful.

Enter Student's ID
S0123
S0123 - Already registered.

Enter Student's ID
S0124
S0124 - Registration successful.
Workshop name - ATU
Capacity - 3
Student ID's - [S0123, S0124]
2 - accepted attempts
2 - rejected attempts
1 - places remaining

Process finished with exit code 0
_

First input: just blank input;
Second input: new user's ID input - Registration Successful;
Third input: enter already existing ID - Already registered;
Fourth input: another new user's ID input - Registration Successful;

In the end the program outputs accepted and rejected attempts of registering, and workshop places remaining(capacity);


## 3. Reflection

**What did you understand during the examination
but struggle to implement?**

Elementary scanner - the most basic Java package and instrument and I just couldn't remember how to use it.
And if-statement logic. They all seemed so easy but I just couldn't implement it correctly.


**What was the most important thing you learned
from correcting your code?**

How to work with Hashset and remembered how to use scanner eventually.

**What would you do differently in your next
coding test?**

I definitely won't fry my brain from studies right before the exam again. 
Because I knew everything and understand all labs and codes that we've gone through before 
and on the exam I just couldn't remember how to use basic scanner. 
Or either I was just too self-confident in my skills, 
however all the review code I wrote for 99% myself. AI was used only for helping with indicating duplicate IDs, my logic was wrong and I couldn't go over it for 40 minutes;

And of course I will learn Java even more deeply for the next coding test. So I won't have any issues with basics things again. 

---

## Review lab assessment and mark recovery

The **review lab** is graded separately out of 20 marks:

| Review criterion | Maximum marks |
|---|---:|
| Original self-assessment and supporting evidence | 4 |
| Explanation of mistakes and Java concepts | 6 |
| Corrections and improvements | 4 |
| Testing and demonstration | 4 |
| Reflection | 2 |
| **TOTAL** | **20** |

You can recover **up to 30% of the marks you lost** in the original examination. The actual amount depends on your review lab grade. Your lecturer's examination grade, **not your self-awarded mark**, is used in the calculation.

**Marks recovered = (100 − original exam mark) × 0.30 × (review lab mark ÷ 20)**

**Revised exam mark = original exam mark + marks recovered**

For example, an original examination mark of 40/100 and a review lab mark of 16/20 would recover 14.4 marks, giving a revised result of **54.4/100**.

The aim is to show that you understand your mistakes and can explain your improvements. Simply copying a working solution does not demonstrate this understanding.

