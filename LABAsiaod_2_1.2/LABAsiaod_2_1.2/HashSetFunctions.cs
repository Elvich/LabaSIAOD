using System;
using System.Collections;
using System.Collections.Generic;

namespace LABAsiaod_2_1._2
{
    public class HashSetFunctions
    {
        private static HashSet<Tree> _ts = new HashSet<Tree>();

        public static void GenerickNewTrees(int numberNewObjects)
        {
            for (int i = 0; i<numberNewObjects; i++)
                _ts.Add(new Tree());
        }

        public static int SearchTree(int treeTypeNumber)
        {
            int countTree = 0;
            Hashtable treeType = new Hashtable()
            {
                { 1, "Spruce" },
                { 2, "Larch" },
                { 3, "Fir" },
                { 4, "Pine" }
            };
            foreach (Tree tree in _ts)
            {
                if (tree.WhichSpecies() == treeType[treeTypeNumber])
                    countTree++;
            }
            return countTree;  
        }

        public static void RemuveTrees()
        {
            _ts.Clear();
        }

        public static void Show()
        {
            foreach (Tree tree in _ts)
                Console.WriteLine(tree);
        }
    }
}
