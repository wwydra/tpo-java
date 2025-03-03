package zad1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {
    public static void processDir(String dirName, String resultFileName) {

        try (FileChannel outputChannel = FileChannel.open(Paths.get(resultFileName), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            Files.walkFileTree(Paths.get(dirName), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)) {
                        try (FileChannel inputChannel = FileChannel.open(file, StandardOpenOption.READ)) {
                            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                            CharsetDecoder decoder = Charset.forName("Cp1250").newDecoder();
                            while (inputChannel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
                                byteBuffer.flip();
                                CharBuffer charBuffer = decoder.decode(byteBuffer);
                                ByteBuffer encodedBuffer = StandardCharsets.UTF_8.encode(charBuffer);
                                outputChannel.write(encodedBuffer);
                                byteBuffer.clear();
                            }
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
