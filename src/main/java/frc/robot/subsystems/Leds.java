// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Leds extends SubsystemBase {
  private AddressableLED m_led;
  private AddressableLEDBuffer m_ledBuffer;
  /** Creates a new LEDS. */
  public Leds() {
    m_led = new AddressableLED(3);
    m_ledBuffer = new AddressableLEDBuffer(120);
    m_led.setLength(m_ledBuffer.getLength());
    m_led.setData(m_ledBuffer);
    m_led.start();

  }

  public void setColorLED() {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i, 32, 62, 543);
    }
  }
  public void whatLightLED() {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setLED(i, Color.kBlueViolet);
    }
  }
  public void royalBlueLED() {
    for (var i = 0; i< m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 0, 59, 174);
    } m_led.setData(m_ledBuffer);
  }
  public void orangeLED() {
    for (var i = 0; i< m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 255, 43, 0);
    }  m_led.setData(m_ledBuffer);
  }
  public void yellowLED() {
    for (var i = 0; i< m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 230, 223, 0);
    }  m_led.setData(m_ledBuffer);
  }
  public void greenLED() {
    for (var i = 0; i< m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 0, 250, 0);
    } m_led.setData(m_ledBuffer);
  }
  public void redLED() {
    for (var i = 0; i< m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 250, 0, 0);
    } m_led.setData(m_ledBuffer);
  }
  public void shadesOFBlue() {
    int length = m_ledBuffer.getLength();
    int blue = 80;
    int red = 20;
    int green = 20;
    while (true) {
        blue = (blue + 50) % 200;
        red = (red - 20) % 20;
        green = (green - 20) % 20;
        for (var i = 0; i < length; i++) {
            m_ledBuffer.setRGB(i, 0, 0, blue); // Измените значения R, G и B, чтобы создать разноцветный эффект
        }
        m_led.setData(m_ledBuffer);
        try {
            Thread.sleep(300); // Подождите некоторое время перед обновлением цвета
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
  } 
  
  public static void givenInputAsString_whenStringToBoolean_thenValidBooleanConversion() {
      assertEquals(Boolean.TRUE, Boolean.valueOf("TRUE"));
      assertEquals(Boolean.FALSE, Boolean.valueOf("false"));
      assertEquals(Boolean.TRUE, Boolean.parseBoolean("True"));
  }
}`