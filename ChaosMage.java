package chaos_Mage;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ChaosMage {

	public static void main(String[] args) {

		// I turned the whole program into a method because I needed a way to return to
		// the beginning on demand
		// Attempts to divide the program into smaller methods caused to many issues, so
		// I gave up on that

		startOver();

	}

	private static boolean check(int[] outOfBag, int gem) {
		// There are 2 gems each for attack, defense and iconic spells
		// This method checks which gems have already been drawn
		// I copied this method from some website that I don't remember after trying for ages to figure it out for myself
		boolean test = IntStream.of(outOfBag).anyMatch(x -> x == gem);
		// System.out.println("Is " + gem + " present in the array: " + test);
		return test;
	}

	public static void startOver() {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int warpEffect = 0;
		int icon = 0;
		int weirdEffect = 0;
		int gem = 0;
		int roundCount = 0;
		int additionalRoll = 0;
		String iconName = "";
		String drawGem = "";
		String spellType = "";
		String warpEffectName = "";
		String lookUp = "";
		String rollDice = "";
		int[] outOfBag = new int[5];
//--------------------------------------------------------------------------------------------------------------
		System.out.println();
		System.out.println("Here is your bag of magic gemstones.");
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			// The user can draw a gem, or put all gems back into the bag
			// Returning gems to the bag is necessary when 5 out of 6 gems have been drawn,
			// or at the end of a fight.
			System.out.println();
			System.out.println("Draw a gem to determine the type of your next spell. (type: draw)");
			System.out.println("Type \"refill\" to return all gems to the bag.");
			System.out.println();
			drawGem = scan.next();

			while (!drawGem.equals("draw") && !drawGem.equals("refill")) {
				System.out.println();
				System.out.println("Draw a gem to determine the type of your next spell. (type: draw)");
				System.out.println("Type \"refill\" to return all gems to the bag.");
				System.out.println();
				drawGem = scan.next();
			}
			if (drawGem.equals("refill")) {
				System.out.println();
				System.out.println("All gems are returned to the bag.");
				System.out.println();
				startOver();
			}
			// if the user draws a gem, a d6 is rolled
			gem = rand.nextInt(6) + 1;

			// A gem that has been drawn stays outside of the bag (until 5 gems have been
			// drawn or the fight is over)
			// So this checks which gems have been removed from the bag
			// It re-rolls the d6 until a gem that is still in the bag is drawn

			while (check(outOfBag, gem)) {
				// System.out.println("nochmal");
				gem = rand.nextInt(6) + 1;

			}

			outOfBag[i] = gem;

			// System.out.println(Arrays.toString(outOfBag));

			// ----------------------------------------------------------------

			switch (gem)
			// Determines which type of magic the results of the d6 correspond to
			{
			case 1:
				spellType = "attack";
				break;
			case 2:
				spellType = "attack";
				break;
			case 3:
				spellType = "defense";
				break;
			case 4:
				spellType = "defense";
				break;
			case 5:
				spellType = "icon";
				break;
			case 6:
				spellType = "icon";
				break;

			}

//---------------------------------------------------------------------------------------------------

			if (spellType.equals("attack")) {
				// Attack and defense spells require further dice rolls to determine two types
				// of additional effect
				warpEffect = rand.nextInt(6) + 1;
				weirdEffect = rand.nextInt(100) + 1;

				switch (warpEffect) {
				case 1:
					warpEffectName = "Air";
					break;
				case 2:
					warpEffectName = "Earth";
					break;
				case 3:
					warpEffectName = "Fire";
					break;
				case 4:
					warpEffectName = "Water";
					break;
				case 5:
					warpEffectName = "Metal";
					break;
				case 6:
					warpEffectName = "Void";
					break;

				}
				System.out.println();
				System.out.println("You can now cast an " + spellType + " spell!" + " Warp Effect " + warpEffectName
						+ " and Weirdness " + weirdEffect + " take effect!");
				System.out.println();
				
				// The gems are automatically returned to the bag after 5 rounds
				roundCount = roundCount + 1;
				if (roundCount == 5) {
					System.out.println();
					System.out.println("All gems are returned to the bag.");
					System.out.println();
					startOver();

				}

			}

			else {
				if (spellType.equals("defense")) {

					warpEffect = rand.nextInt(6) + 1;
					weirdEffect = rand.nextInt(100) + 1;

					switch (warpEffect) {
					case 1:
						warpEffectName = "Air";
						break;
					case 2:
						warpEffectName = "Earth";
						break;
					case 3:
						warpEffectName = "Fire";
						break;
					case 4:
						warpEffectName = "Water";
						break;
					case 5:
						warpEffectName = "Metal";
						break;
					case 6:
						warpEffectName = "Void";
						break;

					}
					System.out.println();
					System.out.println("You can now cast a " + spellType + " spell!" + " Warp Effect " + warpEffectName
							+ " and Weirdness " + weirdEffect + " take effect!");
					System.out.println(
							"If you want to look up the information for your current High Weirdness Effect,type yes.");
					lookUp = scan.next();
					System.out.println();

					if (lookUp.equals("yes")) {
						// Just for demonstration purposes
						// There are normally a few dozen of these effects
						if (weirdEffect <= 50) {
							System.out.println();
							System.out.println("****");
							System.out.println(	"If  you  have  access  to  the  13thAge   Bestiary, \nyou   accidentally   summon  1d3  wibbles  (page  222)  \nthat either attack you \nor drift off to wreak a small amount of havoc elsewhere in the battle. \nIf the GM is  bored  with  that,  \nor  you  don’t  have  the  Bestiary,  \nenormous  air  bubbles   pop   out   of   your   skin   (once)  \nand  deal  damage  to  you  equal to 1d3 x your level.");
							System.out.println("****");
							System.out.println();
						} else {
							if (weirdEffect > 50) {
								System.out.println();
								System.out.println("****");
								System.out.println(
										"Your features shift \nand settle into a temporary new pattern. \nYou gain a random racial ability \nuntil the end of  your  next  turn.  \nIgnore  results  that  duplicate  a  racial  ability  you  already  have.  \nRoll  a  d8.  \n1:  dwarf ’s  that’s  your  best  shot;  \n2:  dark  elf ’s  cruel;    \3:    high    elf ’s    highblood teleport;  \n4:  gnome’s  confounding; 5: half–elf ’s surprising; \n6: halfling’s evasive;   \n7:   holy   one’s   halo;   \n8:   tieflings’s curse   of   chaos.   \n(See   chapter   3   of   the   13th   Age   core   rulebook \nfor racial powers.)");
								System.out.println("****");
								System.out.println("If you want to roll a d8, type roll.");
								rollDice = scan.next();

								if (rollDice.equals("roll")) {
									additionalRoll = rand.nextInt(8) + 1;
									// For demonstration purposes, actual info not included
									switch (additionalRoll) {
									case 1:
										System.out.println("Result 1 and corresponding info");
										System.out.println();
										break;
									case 2:
										System.out.println("Result 2 and corresponding info");
										System.out.println();
										break;
									case 3:
										System.out.println("Result 3 and corresponding info");
										System.out.println();
										break;
									case 4:
										System.out.println("Result 4 and corresponding info");
										System.out.println();
										break;
									case 5:
										System.out.println("Result 5 and corresponding info");
										System.out.println();
										break;
									case 6:
										System.out.println("Result 6 and corresponding info");
										System.out.println();
										break;
									case 7:
										System.out.println("Result 7 and corresponding info");
										System.out.println();
										break;
									case 8:
										System.out.println("Result 8 and corresponding info");
										System.out.println();
										break;

									}
								}
							}
						}

					}

					roundCount = roundCount + 1;
					if (roundCount == 5) {
						System.out.println();
						System.out.println("All gems are returned to the bag.");
						System.out.println();
						startOver();

					}

				}

				else {
					// if an iconic spell is drawn, a d12 determines which specific icon's spells
					// are used
					icon = rand.nextInt(12) + 1;

					switch (icon) {
					case 1:
						iconName = "Archmage";
						break;
					case 2:
						iconName = "Crusader";
						break;
					case 3:
						iconName = "Diabolist";
						break;
					case 4:
						iconName = "Dwarf King";
						break;
					case 5:
						iconName = "Elf Queen";
						break;
					case 6:
						iconName = "Great Gold Wyrm";
						break;
					case 7:
						iconName = "High Druid";
						break;
					case 8:
						iconName = "Lich King";
						break;
					case 9:
						iconName = "Orc Lord";
						break;
					case 10:
						iconName = "Priestess";
						break;
					case 11:
						iconName = "Prince of Shadows";
						break;
					case 12:
						iconName = "The Three";
						break;

					}
					System.out.println();
					System.out.println("You can now cast an " + spellType + " spell! Icon " + iconName
							+ " will grant you their power!");
					System.out.println();
					
					System.out.println();
					System.out.println(iconName + " provides two Spells, Abracadabra and Wingardium Leviosa");
					System.out.println("To roll for Abracadabra, type \"one\".");
					System.out.println("To roll for Wingardium Leviosa, type \"one\".");
					System.out.println();
					//Yes, "one" for both spells is intentional, again, for demonstration purposes

					rollDice = scan.next();
					
					if (rollDice.equals("one" )) {
						int roll = rand.nextInt(6)+1;
						int attack = roll * 4;
						System.out.println();
						System.out.println("The result of your attack roll is " + attack);
						System.out.println();
					}
					roundCount = roundCount + 1;

					if (roundCount == 5) {
						System.out.println();
						System.out.println("All gems are returned to the bag.");
						System.out.println();
						startOver();

					}

				}
			}
		}

	}
}
