package array;

/*
In May 1940, the Allied (British and French) soldiers were stranded on the French beach of Dunkirk. They were surrounded by German army divisions on all sides, who were expected to reach Dunkirk any day and either capture them as Prisoners of War, or destroy them. For safety, the only option remained was an escape to England through the sea.

With the situation hopeless, the British government ordered a massive rescue operation to save the Allied troops from the Germans. They sent large number of civilian boats to rescue the soldiers from Dunkirk. On the beach, hundreds of thousands of soldiers were instructed to form groups of their own. Each boat will pick up one group of soldiers every day. One boat can accommodate only one group and boats are limited.

So to maximise the rescued soldiers following instructions will be followed.
Every day, each group of soldiers should look at its own size, and the size of soldiers immediately to its left. If it is found that the size of their group was more than the size of its immediate left group, then they should board a boat on that day, and smaller group waits for their turn on the next day.

The first group, by default, does not get to board a boat since the group to its immediate left does not exist.

For example, if the size of the groups were
5 9 4 10 12 8 6 11 7 then the groups: (note that individual values will be on newline in the input)

Day 1
x 9 x 10 12 x x 11 x will board the boats (note 12 boards because 12 looks at 10 and not 4) and the groups: 5 x 4 x x 8 6 x 7 will try their luck next day. Remaining groups after day 1 -> 5 4 8 6 7

On the next day (day 2), the groups: x x 8 x 7 will be rescued and the groups: 5 4 x 6 x will try their luck the next day. Remaining groups after day 2 -> 5 4 6

On the next day (day 3), the groups: x x 6 will be rescued and the groups: 5 4 x will try their luck the next day.

Unfortunately, these set of instructions had a major flaw. After some days, the groups will be left in non increasing order of their size, and none of them will be able to board the boats ever.

Your task is to find out the number of days, after which the troops will be left stranded on the beach. For instance in above case after 3rd day no more rescue can take place. So the answer will be 3.

Constraints
7
6 5 8 4 7 10 9
2

 */
public class DunkirkRescue {


  public static int solution(int n, int[] arr) {

    int m = arr[0];
    int c = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[i - 1]) {
        continue;
      }

      if (m < arr[i]) {
        c++;
      }
    }

    return c;
  }

}
