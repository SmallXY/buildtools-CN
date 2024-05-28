package org.spigotmc.builder;

import com.google.common.base.Joiner;
import java.awt.GraphicsEnvironment;
import joptsimple.OptionSet;
import org.spigotmc.gui.BuildToolsGui;
import org.spigotmc.utils.Flags;
import org.spigotmc.utils.SwingUtils;
import org.spigotmc.utils.Utils;

public class Bootstrap
{

    private static boolean guiEnabled = false;

    public static void main(String[] args) throws Exception
    {
        OptionSet options = Flags.PARSER.parse( args );

        if ( ( args.length == 0 && !Utils.isRanFromCommandLine() ) || options.has( Flags.GUI_FLAG ) )
        {
            if ( !options.has( Flags.NO_GUI_FLAG ) )
            {
                if ( !GraphicsEnvironment.isHeadless() )
                {
                    guiEnabled = true;

                    SwingUtils.applyInitialTheme();

                    BuildToolsGui gui = new BuildToolsGui();
                    gui.setLocationRelativeTo( null );
                    gui.setVisible( true );
                } else {
                    System.err.println( "检测到无头环境疑似linux服务器版本，BuildTools GUI不可用" );
                }
            }
        }

        if ( !guiEnabled )
        {
            JavaVersion javaVersion = JavaVersion.getCurrentVersion();

            if ( javaVersion.isUnknown() )
            {
                System.err.println( "检测到不支持的Java版本 (" + System.getProperty( "java.class.version" ) + "). BuildTools 仅测试至Java 22版本。不支持使用开发中的Java版本" );
                System.err.println( "您可以使用 `java -version` 命令来再次确认您的Java版本。" );
            }

            long memoryMb = Runtime.getRuntime().maxMemory() >> 20;
            if ( memoryMb < 448 ) // Older JVMs (including Java 8) report less than Xmx here. Allow some slack for people actually using -Xmx512M
            {
                System.err.println( "BuildTools需要至少512M的内存才能运行（建议1024M），但检测到的内存不足 你才拥有" + memoryMb + "M." );
                System.err.println( "这通常发生在您运行的是32位系统，或者是一个内存较低的系统." );
                System.err.println( "请手动指定内存重新运行BuildTools，例如：java -Xmx1024M -jar BuildTools.jar " + Joiner.on( ' ' ).join( args ) );
                System.exit( 1 );
            }

            Builder.logOutput( System.out, System.err );
            Builder.startBuilder( args, options );
        }
    }
}
