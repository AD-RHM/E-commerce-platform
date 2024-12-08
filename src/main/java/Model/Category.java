package Model;

public enum Category{;

    enum Computers{
        Desktops("Desktops"), Laptops("Laptops"), MiniPCs("Mini PCs");
        private final String displayName;

        Computers(String displayName) {
            this.displayName = displayName;
        }
        public String displayName() { return displayName; }
        // Optionally and/or additionally, toString.
        @Override public String toString() { return displayName; }
    }
    enum Components{
        Processors("Processors (CPUs)"), Graphics("Graphics Cards (GPUs)"), Motherboards("Motherboards"), Memory("Memory (RAM)"), Storage("Storage (HDDs, SSDs, NVMe drives)"),
        Supplies("Power Supplies (PSUs)"), Cooling("Cooling Solutions (Fans, Liquid Cooling Systems)"), Cables_Adapters("Cables and Adapters"), Bags_Cases("Bags and Cases");
        private final String displayName;
        Components(String displayName) {
            this.displayName = displayName;
        }
        public String displayName() { return displayName; }
        @Override public String toString() { return displayName; }
    }
    enum Peripherals{
        Monitors("Monitors"), Keyboards("Keyboards (Mechanical, Membrane, Wireless)"), Mice("Mice (Gaming, Ergonomic, Wireless)"), Printers_Scanners("Printers and Scanners"),
        Headphones_Microphones("Headphones and Microphones"), Webcams("Webcams");
        private final String displayName;
        Peripherals(String displayName) {
            this.displayName = displayName;
        }
        public String displayName() { return displayName; }
        @Override public String toString() { return displayName; }
    }
    enum Networking{
        Routers_Modems("Routers and Modems"), Switches("Switches"), Network_Adapters_Cards("Network Adapters and Cards"), WiFi_Extenders("Wi-Fi Extenders"),
        Cables("Cables");
        private final String displayName;
        Networking(String displayName) {
            this.displayName = displayName;
        }
        public String displayName() { return displayName; }
        @Override public String toString() { return displayName; }
    }
    enum Software{
        Operating_Systems("Operating Systems"), Productivity_Tools("Productivity Tools"), Development_Tools("Development Tools"), Antivirus("Antivirus and Security"),
        Multimedia_Editing_Tools("Multimedia Editing Tools"), Licenses_Subscriptions("Licenses and Subscriptions");
        private final String displayName;
        Software(String displayName) {
            this.displayName = displayName;
        }
        public String displayName() { return displayName; }
        @Override public String toString() { return displayName; }
    }
    enum Gaming{
        Gaming_Consoles("PlayStation, Xbox, Nintendo"), Gaming_Accessories("Controllers, VR Headsets, Joysticks"), Gaming_Chairs_Desks("Gaming Chairs and Desks"),
        GameTitles_Subscriptions("Game Titles and Subscriptions");
        private final String displayName;
        Gaming(String displayName) {
            this.displayName = displayName;
        }
        public String displayName() { return displayName; }
        @Override public String toString() { return displayName; }
    }
}
