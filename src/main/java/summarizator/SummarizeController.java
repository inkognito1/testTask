package summarizator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import summarizator.SummarizeNumbers;

import static jdk.nashorn.internal.runtime.PropertyDescriptor.GET;

@RestController
@RequestMapping("/api")
@EnableWebMvc
public class SummarizeController {

    @Autowired
    private Summarize summarize;

    @RequestMapping("/manual")
    public String index() {
        String usage = "Please use as follows hostname wiht default port 8080 and two int parameters: \n" +
                "http://localhost:8080/api/summarizer?intOne=4&intTwo=3 ";
        return usage;
    }

    @RequestMapping(value = "/summarizer",
            params = {"intOne", "intTwo"})
    @ResponseBody
    public int postFoos( @RequestParam(value = "intOne") int intOne,
                            @RequestParam(value = "intTwo") int intTwo
                            ) throws Exception {
        int result = summarize.sum(Integer.valueOf(intOne), Integer.valueOf(intTwo));
        return result;
    }
}
