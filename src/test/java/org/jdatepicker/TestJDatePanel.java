/**
 Copyright 2004 Juan Heyns. All rights reserved.

 Redistribution and use in source and binary forms, with or without modification, are
 permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this list of
 conditions and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright notice, this list
 of conditions and the following disclaimer in the documentation and/or other materials
 provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY JUAN HEYNS ``AS IS'' AND ANY EXPRESS OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JUAN HEYNS OR
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 The views and conclusions contained in the software and documentation are those of the
 authors and should not be interpreted as representing official policies, either expressed
 or implied, of Juan Heyns.
 */
package org.jdatepicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jdatepicker.constraints.RangeConstraint;

public class TestJDatePanel {

    public static void main(String[] args) {
        JFrame testFrame = new JFrame();
        final DatePanel panel = new JDatePanel();
        panel.setShowYearButtons(true);
        testFrame.getContentPane().add((JComponent)panel);
        // TODO create a feature class to describe these types of variables
        panel.setShowYearButtons(false);
        panel.setShowYearButtons(true);

        Calendar afterDay = Calendar.getInstance();
        afterDay.setTime(new Date());

        Calendar beforeDay = Calendar.getInstance();
        beforeDay.setTime(new Date());
        beforeDay.add(Calendar.DAY_OF_MONTH, 3);

        panel.addDateSelectionConstraint(new RangeConstraint(afterDay, beforeDay));

        testFrame.setSize(300, 300);
        testFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        testFrame.setVisible(true);

        panel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.err.println(panel.getModel().getDay());
            }
        });

        panel.getModel().setDate(afterDay.get(Calendar.YEAR), afterDay.get(Calendar.MONTH), afterDay.get(Calendar.DATE));
    }

}
