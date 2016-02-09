###Date: 16/09/2015
###Source: [Code Jam](https://code.google.com/codejam/contest/4254486/dashboard)
###Problem Description
The country of Fairland has very strict laws governing how companies organize and pay their employees:

Each company must have exactly one CEO, who has no manager.
Every employee except for the CEO must have exactly one manager. (This means that the org chart showing all of the employees in a company is a tree, without cycles.)
As long as an employee is working for the company, their manager must never change. This means that if a manager leaves, then all of the employees reporting to that manager must also leave.
The CEO must never leave the company.
Every employee receives a salary -- some amount of Fairland dollars per year. An employee's salary must never change.
Different employees may have different salaries, and an employee's salary is not necessarily correlated with where in the org chart that employee is.
The government of Fairland has just passed one additional law:
The difference between the largest salary and the smallest salary in the whole company must be at most D Fairland dollars.
Marie is the CEO of the Fairland General Stuff Corporation, and she has to ensure that her company complies with the new law. This may require laying off some employees. She has the list of the company's employees, their managers, and their salaries. What is the largest number of employees she can keep, including herself?

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each case begins with one line containing two space-separated integers N (the number of employees) and D (the maximum allowed salary difference). This is followed by one line with four space-separated integers (S0, As, Cs, Rs) and then another line with four more space-separated integers (M0, Am, Cm and Rm). These last eight integers define the following sequences:
Si+1 = (Si * As + Cs) mod Rs
Mi+1 = (Mi * Am + Cm) mod Rm
Marie's employee ID is 0, and all other employees have IDs from 1 to N - 1, inclusive. The salary of employee i is Si. For every employee i other than Marie, the manager is Mi mod i. (Note that this means that M0 does not affect Marie's manager -- she has none!)

Output

For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the largest number of employees Marie can keep at the company, including herself, such that all of laws 1-7 are obeyed.


#Retrospective - First Session 
1. We might have a problem where we can apply TDD 
2. TDD made us think of the design 
3. It is better to have complex problems 
4. Complex problems trigger discussion 
5. I felt hard to follow up 
6. Better than straight forward problems 
7. I like the discussion before writing the code 
8. I understood the problem because of the discussion 
9. Discussions gave us ore than one algorithms 
10. To be continued in a later session 

#Retrospective - Second Session 
1. Too much discussion, we go lost with the different ideas
2. We lost time in discussion 
3. Time difference between sessions was too long 
4. We should have reread the code ahead time
5. Very nice 
6. I like the session even if we didn't write enough code 