package com.example.service.impl;

import org.jvnet.hk2.annotations.Service;

import com.example.service.CoachService;

import jakarta.inject.Named;

public class CricketCoachService implements CoachService {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15m";
    }
}
