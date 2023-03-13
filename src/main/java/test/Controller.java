package test;

import java.util.concurrent.ForkJoinPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class Controller {

	private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/sync")
	public ResponseEntity<?> sync(Model model) {
	   return ResponseEntity.ok().header("Cache-Control", "max-age=0").body("ok");
	}
	
	@GetMapping("/async")
	public DeferredResult<ResponseEntity<?>> async(Model model) {
	    LOG.info("Received async-deferredresult request");
	    DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();
	    
	    ForkJoinPool.commonPool().submit(() -> {
	        LOG.info("Processing in separate thread");
	        try {
	            Thread.sleep(6000);
	        } catch (InterruptedException e) {
	        }
	        output.setResult(ResponseEntity.ok().header("Cache-Control", "max-age=0").body("ok"));
	    });
	    
	    LOG.info("servlet thread freed");
	    return output;
	}
	
}
