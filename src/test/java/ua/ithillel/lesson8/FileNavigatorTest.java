package ua.ithillel.lesson8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileNavigatorTest {
    private FileNavigator target;
    private final FileData root_bin = new FileData("bin", 1000,"/root");
    private final FileData root_data = new FileData("data", 1098,"/root");
    private final FileData root_lib = new FileData("lib", 2300,"/root");
    private final FileData ect_project = new FileData("project", 4532,"/ect");
    private final FileData src_main = new FileData("main", 7420,"/src");
    private final FileData src_test = new FileData("test", 3586,"/src");

    @BeforeEach
    void setUp() {
        target = new FileNavigator();

        target.add("/root",root_bin);
        target.add("/root",root_data);
        target.add("/root",root_lib);
        target.add("/ect",ect_project);
        target.add("/src",src_main);
        target.add("/src",src_test);
    }

    @Test
    void shouldAdd(){

        var expected = Map.of(
                "/src", List.of(src_main, src_test),
                "/ect",List.of(ect_project),
                "/root", List.of(root_bin, root_data, root_lib)
        );

        assertEquals(target.getAll(), expected);

    }

    @Test
    void shouldFileExceptionBetweenPath() {
        FileData src_test = new FileData("test", 3586,"/src");

        assertThrows(FileExceptionBetweenPath.class, new Executable() {
            @Override
            public void execute() throws RuntimeException {
                target.add("/ect", src_test);
            }
        });
    }

    @Test
    void shouldRemove1(){

        target.remove("/root");

        var expected = Map.of(
                "/src", List.of(src_main, src_test),
                "/ect",List.of(ect_project)

        );

        assertEquals(target.getAll(), expected);

    }

    @Test
    void shouldRemove2(){

        target.remove("/src");

        var expected = Map.of(
                "/ect",List.of(ect_project),
                "/root", List.of(root_bin, root_data, root_lib)

        );

        assertEquals(target.getAll(), expected);

    }

    @Test
    void shouldFindElement(){

        assertEquals(target.find("/root"), List.of(root_bin, root_data, root_lib));
        assertEquals(target.find("/ect"), List.of(ect_project));
        assertEquals(target.find("/src"), List.of(src_main, src_test));

    }
    @Test
    void shouldFilterBySize(){

        assertEquals(target.filterBySize( 2085), List.of(root_bin, root_data));

        List<FileData> result = List.of(root_bin, root_data, root_lib, src_test);
        assertTrue(target.filterBySize( 4396).size() == result.size() && target.filterBySize( 4396).containsAll(result) && result.containsAll(target.filterBySize( 4396)));

    }
    @Test
    void shouldSortBySize(){

        assertEquals(target.sortBySize(), List.of(root_bin, root_data, root_lib, src_test,ect_project, src_main));

    }

}
