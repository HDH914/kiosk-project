package com.HDH.kiosk.dto.Validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({
        ValidationGroups.NotBlackGroup.class,
        ValidationGroups.SizeCheckGroups.class,
        ValidationGroups.PatternCheckGroup.class,
        Default.class
})
public interface ValidationSequence {

}
