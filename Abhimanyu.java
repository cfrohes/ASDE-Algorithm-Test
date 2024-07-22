package my;
import java.util.Scanner;

public class Abhimanyu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Initialize the enemy powers
        int[] enemyPowers = new int[11];
        System.out.println("Enter powers of enemies in 11 circles: ");
        for (int i = 0; i < 11; i++) {
            enemyPowers[i] = scanner.nextInt();
        }

        // Step 2: Initialize Abhimanyu's power, number of skips, and recharges
        System.out.print("Enter Abhimanyu's initial power: ");
        int abhimanyuPower = scanner.nextInt();

        System.out.print("Enter the number of skips: ");
        int skips = scanner.nextInt();

        System.out.print("Enter the number of recharges: ");
        int recharges = scanner.nextInt();

        // Step 3: Determine if Abhimanyu can cross the Chakravyuha
        boolean canCross = canAbhimanyuCross(enemyPowers, abhimanyuPower, skips, recharges);

        // Step 4: Display the result
        if (canCross) {
            System.out.println("Abhimanyu can cross the Chakravyuha.");
        } else {
            System.out.println("Abhimanyu cannot cross the Chakravyuha.");
        }

        scanner.close();
    }

    public static boolean canAbhimanyuCross(int[] enemyPowers, int abhimanyuPower, int skips, int recharges) {
        // Initialize flags for regenerating enemies
        boolean k3Regenerated = false;
        boolean k7Regenerated = false;

        // Step 5: Iterate through each circle
        for (int i = 0; i < enemyPowers.length; i++) {
            // Step 5.1: Check if skips are available
            if (skips > 0) {
                skips--;
                continue;
            }

            // Step 5.2: Check if Abhimanyu's power is less than the enemy's power
            if (abhimanyuPower < enemyPowers[i]) {
                // Step 5.3: Use a recharge if available
                if (recharges > 0) {
                    abhimanyuPower += enemyPowers[i];
                    recharges--;
                } else {
                    return false; // Abhimanyu cannot cross
                }
            }

            // Step 5.4: Deduct the enemy's power from Abhimanyu's power
            abhimanyuPower -= enemyPowers[i];

            // Step 5.5: Handle regeneration of k3 enemy
            if (i == 2 && !k3Regenerated) {
                k3Regenerated = true;
                int k3RegenPower = enemyPowers[2] / 2;
                if (abhimanyuPower < k3RegenPower) {
                    if (recharges > 0) {
                        abhimanyuPower += k3RegenPower;
                        recharges--;
                    } else {
                        return false;
                    }
                }
                abhimanyuPower -= k3RegenPower;
            }

            // Step 5.6: Handle regeneration of k7 enemy
            if (i == 6 && !k7Regenerated) {
                k7Regenerated = true;
                int k7RegenPower = enemyPowers[6] / 2;
                if (abhimanyuPower < k7RegenPower) {
                    if (recharges > 0) {
                        abhimanyuPower += k7RegenPower;
                        recharges--;
                    } else {
                        return false;
                    }
                }
                abhimanyuPower -= k7RegenPower;
            }
        }

        return true;
    }
}

