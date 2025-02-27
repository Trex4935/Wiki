//joseph sysuid tutoirla !!!

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.SignalLogger;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import frc.robot.Constants;

public class CoralIntake extends SubsystemBase {
  final VoltageOut m_sysIdControl = new VoltageOut(0);

  public final TalonFX motorexamplefortewstitnadogldg;
 //this creates the sysid routine 
 private final SysIdRoutine m_sysIdRoutine;


  public CoralIntake() {
    coralIntakeMotor = new TalonFX(8);

    m_sysIdRoutine =
        new SysIdRoutine(
            new SysIdRoutine.Config(
                null, // Use default ramp rate (1 V/s)
                Volts.of(1.85), // Reduce dynamic voltage to 4 to prevent brownout
                null, // Use default timeout (10 s)
                // Log state with Phoenix SignalLogger class
                state -> SignalLogger.writeString("MECH SYSID", state.toString())),
            new SysIdRoutine.Mechanism(
                volts -> motorexamplefortewstitnadogldg.setControl(m_sysIdControl.withOutput(volts)),
                null,
                this));
  }
//what drives the thingie
  public Command sysIdQuasistatic(SysIdRoutine.Direction direction) {
    return m_sysIdRoutine.quasistatic(direction);
  }

  public Command sysIdDynamic(SysIdRoutine.Direction direction) {
    return m_sysIdRoutine.dynamic(direction);
  }
//this should be for robotcontainer

    control.povRight().onTrue(Commands.runOnce(SignalLogger::start));
    control.povLeft().onTrue(Commands.runOnce(SignalLogger::stop));

    control.y().whileTrue(m_coralIntake.sysIdQuasistatic(SysIdRoutine.Direction.kForward));
    control.a().whileTrue(m_coralIntake.sysIdQuasistatic(SysIdRoutine.Direction.kReverse));

    control.b().whileTrue(m_coralIntake.sysIdDynamic(SysIdRoutine.Direction.kForward));
    control.x().whileTrue(m_coralIntake.sysIdDynamic(SysIdRoutine.Direction.kReverse));
