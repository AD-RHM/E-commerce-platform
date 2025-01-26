package Entities;

public enum Category {
    // Computers
    DESKTOPS("Desktops", CategoryGroup.COMPUTERS),
    LAPTOPS("Laptops", CategoryGroup.COMPUTERS),
    MINIPCS("Mini PCs", CategoryGroup.COMPUTERS),

    // Components
    PROCESSORS("Processors (CPUs)", CategoryGroup.COMPONENTS),
    GRAPHICS("Graphics Cards (GPUs)", CategoryGroup.COMPONENTS),
    MOTHERBOARDS("Motherboards", CategoryGroup.COMPONENTS),
    MEMORY("Memory (RAM)", CategoryGroup.COMPONENTS),
    STORAGE("Storage (HDDs, SSDs, NVMe drives)", CategoryGroup.COMPONENTS),
    POWER_SUPPLIES("Power Supplies (PSUs)", CategoryGroup.COMPONENTS),
    COOLING("Cooling Solutions (Fans, Liquid Cooling Systems)", CategoryGroup.COMPONENTS),
    CABLES_ADAPTERS("Cables and Adapters", CategoryGroup.COMPONENTS),
    BAGS_CASES("Bags and Cases", CategoryGroup.COMPONENTS),

    // Peripherals
    MONITORS("Monitors", CategoryGroup.PERIPHERALS),
    KEYBOARDS("Keyboards (Mechanical, Membrane, Wireless)", CategoryGroup.PERIPHERALS),
    MICE("Mice (Gaming, Ergonomic, Wireless)", CategoryGroup.PERIPHERALS),
    PRINTERS_SCANNERS("Printers and Scanners", CategoryGroup.PERIPHERALS),
    HEADPHONES_MICROPHONES("Headphones and Microphones", CategoryGroup.PERIPHERALS),
    WEBCAMS("Webcams", CategoryGroup.PERIPHERALS),

    // Networking
    ROUTERS_MODEMS("Routers and Modems", CategoryGroup.NETWORKING),
    SWITCHES("Switches", CategoryGroup.NETWORKING),
    NETWORK_ADAPTERS_CARDS("Network Adapters and Cards", CategoryGroup.NETWORKING),
    WIFI_EXTENDERS("Wi-Fi Extenders", CategoryGroup.NETWORKING),
    NETWORK_CABLES("Cables", CategoryGroup.NETWORKING),

    // Software
    OPERATING_SYSTEMS("Operating Systems", CategoryGroup.SOFTWARE),
    PRODUCTIVITY_TOOLS("Productivity Tools", CategoryGroup.SOFTWARE),
    DEVELOPMENT_TOOLS("Development Tools", CategoryGroup.SOFTWARE),
    ANTIVIRUS("Antivirus and Security", CategoryGroup.SOFTWARE),
    MULTIMEDIA_EDITING_TOOLS("Multimedia Editing Tools", CategoryGroup.SOFTWARE),
    LICENSES_SUBSCRIPTIONS("Licenses and Subscriptions", CategoryGroup.SOFTWARE),

    // Gaming
    GAMING_CONSOLES("PlayStation, Xbox, Nintendo", CategoryGroup.GAMING),
    GAMING_ACCESSORIES("Controllers, VR Headsets, Joysticks", CategoryGroup.GAMING),
    GAMING_CHAIRS_DESKS("Gaming Chairs and Desks", CategoryGroup.GAMING),
    GAME_TITLES_SUBSCRIPTIONS("Game Titles and Subscriptions", CategoryGroup.GAMING);

    private final String displayName;
    private final CategoryGroup group;

    // Constructor
    Category(String displayName, CategoryGroup group) {
        this.displayName = displayName;
        this.group = group;
    }

    public String getDisplayName() {
        return displayName;
    }

    public CategoryGroup getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return displayName;
    }

    // Enum to Represent Groups
    public enum CategoryGroup {
        COMPUTERS,
        COMPONENTS,
        PERIPHERALS,
        NETWORKING,
        SOFTWARE,
        GAMING;
    }
}

