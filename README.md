# ASDE-Algorithm-Test
/*Imagine Abhimanyu in Chakravyuha. There are 11 circles in the Chakravyuha surrounded by different enemies. Abhimanyu is located in the innermost circle and has to cross all the 11 circles to reach Pandavas army back. 
 
Given:
•	 Each circle is guarded by different enemy where enemy is equipped with k1, k2……k11 powers Abhmanyu start from the innermost circle with p power Abhimanyu has a boon to skip fighting enemy a times 
•	Abhmanyu can recharge himself with power b times 
•	Battling in each circle will result in loss of the same power from Abhimanyu as the enemy. 
•	If Abhmanyu enter the circle with energy less than the respective enemy, he will lose the battle
•	 k3 and k7 enemies are endured with power to regenerate themselves once with half of their initial power and can attack Abhimanyu from behind if he is battling in iteratively next circle */
 
============================================================================================
# Write an algorithm to find if Abhimanyu can cross the Chakravyuh and test it with two sets of test cases.
============================================================================================
# Algorithm to Determine if Abhimanyu Can Cross the Chakravyuh

# 1)Input Initialization:

   - Read the power levels of the enemies in each of the 11 circles.
   - Read Abhimanyu's initial power.
   - Read the number of skips Abhimanyu can use.
   - Read the number of recharges available to Abhimanyu.

# 2)Iterate Through Each Circle:

   - For each circle from 1 to 11:
       - If skips are available, use a skip and move to the next circle.
       - If Abhimanyu's power is less than the enemy's power:
           - If recharges are available, use one recharge to increase Abhimanyu's power by the enemy's power.
           - If no recharges are left, Abhimanyu loses the battle and the algorithm returns false.
       - Deduct the enemy's power from Abhimanyu's power.

# 3)Handle Special Enemies:

   - For the 3rd and 7th circles, handle the regenerating enemies:
       - If Abhimanyu defeats the initial enemy but their regenerated power is still a threat:
           - If Abhimanyu's power is less than the regenerated enemy's power:
               - If recharges are available, use one recharge to increase Abhimanyu's power by the regenerated enemy's power.
               - If no recharges are left, Abhimanyu loses the battle and the algorithm returns false.
           - Deduct the regenerated enemy's power from Abhimanyu's power.

# 4)Final Check:

   - If Abhimanyu survives all 11 circles, return true.
========================================================================================
# Test Cases
# Test Case 1

    Enter powers of enemies in 11 circles: 
    5 10 20 15 30 25 40 35 45 50 60
    Enter Abhimanyu's initial power: 200
    Enter the number of skips: 3
    Enter the number of recharges: 5
    Expected Result: Abhimanyu can cross the Chakravyuha.
 =====================================================================================
# Test Case 2

    Enter powers of enemies in 11 circles: 
    10 20 15 30 25 40 35 45 50 55 60
    Enter Abhimanyu's initial power: 50
    Enter the number of skips: 1
    Enter the number of recharges: 1
    Expected Result: Abhimanyu cannot cross the Chakravyuha.
