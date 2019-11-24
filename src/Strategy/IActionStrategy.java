/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Characters.MainCharacter;

/**
 *
 * @author Gabriel
 */
public interface IActionStrategy {
    public boolean action(MainCharacter character);
}
