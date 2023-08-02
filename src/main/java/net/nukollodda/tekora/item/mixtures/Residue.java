package net.nukollodda.tekora.item.mixtures;

import net.minecraft.world.item.Item;

public class Residue extends AbstractMixtures {
    public enum Components {
        ;

        private final int id;
        private final Item item;

        Components(int id, Item pItem) {
            this.id = id;
            this.item = pItem;
        }

        public int getId() {
            return id;
        }

        public Item getItem() {
            return item;
        }
    }
}
