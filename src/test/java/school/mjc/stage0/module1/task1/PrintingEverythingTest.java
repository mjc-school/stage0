package school.mjc.stage0.module1.task1;

import org.junit.jupiter.api.Test;
import school.mjc.task.verifier.test.BaseIOTest;

import static school.mjc.task.verifier.Util.parse;
import static school.mjc.task.verifier.assertion.CompilationUnitAssertion.assertThat;
import static school.mjc.task.verifier.matcher.DSL.*;

class PrintingEverythingTest extends BaseIOTest {

    @Test
    void printingEverythingTest() {
        PrintingEverything.main(null);
        assertOutput("This is a string", "123.14", "", "This is another string");

        var parsedCode = parse("src/main/java/school/mjc/stage0/module1/task1/PrintingEverything.java");

        assertThat(parsedCode).hasSingleMainMethod(main -> {
            main.hasSingle(sout().withArgument(stringLiteral("This is a string")));
            main.hasSingle(sout().withArgument(intLiteral(1)).allowOnlyPrint());
            main.hasSingle(sout().withArgument(intLiteral(2)).allowOnlyPrint());
            main.hasSingle(sout().withArgument(doubleLiteral(3.14)));
            main.has(sout().withoutArguments());
            main.hasSingle(sout().withArgument(stringLiteral("This is another string")));
        });
    }
}