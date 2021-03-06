package cmdline;

import packetLib.PacketWriter;
import user.Client;
import user.Header;

public class ExitCommand implements Command
{
    String name;

    /* A little weird if one client makes 2 connections to another client.
     * Since it will create multiple connections to same ip/port, the mapping will be overwritten...
     */
    public void handle(Client c, String[] cmd)
    {
        if (cmd.length == 1)
        {
            System.out.println("Client closing.");
            PacketWriter pw = new PacketWriter(Header.DISCONNECT);
            for (String s : c.chatList.keySet())
                c.chatList.get(s).sendPacket(pw);
            System.exit(0);
        }
        System.out.println(usage());
    }

    public String usage()
    {
        return "Usage: /" + name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
