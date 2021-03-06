package v01.controllers;

import jssc.SerialPortException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import v01.commands.PanTiltLimitSetCommand;

@Controller
public class PanTiltLimitSetCommandController {

    private PanTiltLimitSetCommand panTiltLimitSetCommand = new PanTiltLimitSetCommand();

    @RequestMapping(value = "/PanTiltLimitSet_limitSet")
    public String panTiltLimitSetLimitSet(@RequestParam int corner, @RequestParam int panPosition, @RequestParam int tiltPosition) throws SerialPortException, InterruptedException {
        panTiltLimitSetCommand.limitSet(corner, panPosition, tiltPosition).execute();
        return "redirect:/?command=PanTiltLimitSet_limitSet";
    }

    @RequestMapping(value = "/PanTiltLimitSet_limitClear")
    public String panTiltLimitSetLimitClear(@RequestParam int corner) throws SerialPortException, InterruptedException {
        panTiltLimitSetCommand.limitClear(corner).execute();
        return "redirect:/?command=panTiltLimitSet_limitClear";
    }
}
