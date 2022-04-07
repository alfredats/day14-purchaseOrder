package visa.vttp.paf.day14purchaseOrder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import visa.vttp.paf.day14purchaseOrder.model.OrderFormWrapper;
import visa.vttp.paf.day14purchaseOrder.service.PurchaseOrderService;

@Controller
@RequestMapping(path = {"/"})
public class PurchaseOrderController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);
    
    @Autowired
    private PurchaseOrderService poSvc;

    @GetMapping
    ModelAndView indexResource() {
        final ModelAndView mav = new ModelAndView("index.html");
        mav.addObject("orderForm", new OrderFormWrapper());
        return mav;
    }

    @PostMapping(path="/purchase_order")
    ModelAndView purchaseOrder(
        @ModelAttribute OrderFormWrapper ofw 
    ) {
        logger.info(">>> Order Form: " + ofw.toString());
        ModelAndView mav;

        poSvc.submitPurchaseOrder(ofw);

        mav = new ModelAndView("redirect:/");
        return mav;
    }

}
