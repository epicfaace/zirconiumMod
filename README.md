#Zirconium Mod!

##HUHUHU TEST

[Flavored markdown](https://help.github.com/articles/github-flavored-markdown)

![Zirconium Logo](splash.png)

Press 'm' to show a markdown cheat sheet! Yay!

###TEST:
```

        /**
         * Returns the ID of the items to drop on destruction.
         */
        public int idDropped(int par1, Random par2Random, int par3)
        {
                return Item.redstone.shiftedIndex;
        }
        /**
         * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
         */
        public int quantityDroppedWithBonus(int par1, Random par2Random)
        {
                return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
        }
        /**
         * Returns the quantity of items to drop on block destruction.
         */
        public int quantityDropped(Random par1Random)
        {
                return 4 + par1Random.nextInt(2);
        }



```
