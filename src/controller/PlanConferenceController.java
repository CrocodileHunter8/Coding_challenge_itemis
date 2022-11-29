package controller;

import model.ConferenceEvent;

import java.util.ArrayList;

public class PlanConferenceController {
    /* implementing the knapsack algorithm into this method
    the algorithm is from https://www.geeksforgeeks.org/printing-items-01-knapsack/
	Prints the items which are put in a knapsack of capacity W
     */
    static void printknapSack(int capacity, ArrayList<ConferenceEvent> sourceList, ArrayList<ConferenceEvent>  targetList)
    {
        int n = sourceList.size();
        int i, w;
        int K[][] = new int[n + 1][capacity + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= capacity; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (sourceList.get(i-1).getDuration() <= w)
                    K[i][w] = Math.max(sourceList.get(i-1).getDuration() + K[i - 1][w - sourceList.get(i-1).getDuration()], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        // stores the result of Knapsack
        int res = K[n][capacity];
        System.out.println("Result: " + res + "/" + capacity);

        w = capacity;
        for (i = n; i > 0 && res > 0; i--)
        {

            // either the result comes from the top
            // (K[i-1][w]) or from (val[i-1] + K[i-1]
            // [w-val[i-1]]) as in Knapsack table. If
            // it comes from the latter one/ it means
            // the item is included.
            if (res == K[i - 1][w])
                continue;
            else
            {

                //System.out.println(val[i - 1] + " ");//For debugging

                // This item is included, add it to target list
                targetList.add(sourceList.get(i-1));

                // Since this weight is included its
                // value is deducted
                res = res - sourceList.get(i-1).getDuration();
                w = w - sourceList.get(i-1).getDuration();
            }
        }
    }
}
