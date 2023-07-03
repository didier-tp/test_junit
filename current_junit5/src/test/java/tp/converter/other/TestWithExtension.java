package tp.converter.other;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.extensions.MyBasicLogExtension;
import tp.extensions.MyPerfCustomExtension;

@ExtendWith({ MyPerfCustomExtension.class , MyBasicLogExtension.class })
public class TestWithExtension {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithExtension.class);
	
	/*
	 NB: Junit4 Rule can be replaced by JUnit5 extension
	 */
	
	
	@Test
	public void fastTest() {
		try {
			Thread.sleep(20);//ok
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	//@Ignore
	public void slowTest() {
		try {
			Thread.sleep(60);//ok
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@TempDir
	File tempDir;

	@Test
	void testWithTempDir() throws IOException {
	    assertTrue(this.tempDir.isDirectory(),"Should be a directory ");

	    File f1 = new File(tempDir, "f1.txt");
	    List<String> lines = Arrays.asList("aaa", "bbb", "ccc");

	    Files.write(f1.toPath(), lines);

	    assertAll(
	      () -> assertTrue( Files.exists(f1.toPath()) , "File should exist"),
	      () -> assertLinesMatch(lines, Files.readAllLines(f1.toPath())));
	}

}
