package com.example.schoolmangementsystem.model;

import jdk.jfr.Enabled;
import lombok.Data;

@Enabled
@Data
public class Question extends BaseEntity
{
	String questionType;
	String questionHead;
	String answer;
}
