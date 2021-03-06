/*
 * This software Copyright by the RPTools.net development team, and
 * licensed under the Affero GPL Version 3 or, at your option, any later
 * version.
 *
 * MapTool Source Code is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public
 * License * along with this source Code.  If not, please visit
 * <http://www.gnu.org/licenses/> and specifically the Affero license
 * text at <http://www.gnu.org/licenses/agpl.html>.
 */
package net.rptools.dice.expressiontree;

import java.util.Collection;
import java.util.Collections;
import net.rptools.dice.result.DiceExprResult;
import net.rptools.dice.symbols.DiceEvalScope;
import net.rptools.dice.symbols.DiceExpressionSymbolTable;

/** Represents the node used to resolve a symbol from the symbol table. */
public class ResolveSymbolDiceExpressionNode implements DiceExpressionNode {

  /** The name of the symbol. */
  private final String name;

  /** The scope of the symbol. */
  private final DiceEvalScope scope;

  /** The evaluated value of this node. */
  private DiceExprResult result;

  /**
   * Creates a new node used to resolve a symbol from the symbol table.
   *
   * @param symbol The name of the symbol.
   * @param symbolScope The scope of the symbol.
   */
  public ResolveSymbolDiceExpressionNode(String symbol, DiceEvalScope symbolScope) {
    name = symbol;
    scope = symbolScope;
  }

  @Override
  public DiceExprResult evaluate(DiceExpressionSymbolTable symbolTable)
      throws UnsupportedOperationException {
    result = symbolTable.getVariableValue(scope, name);
    return result;
  }

  @Override
  public DiceExprResult getExprResult() {
    return result;
  }

  @Override
  public Collection<DiceExpressionNode> getChildren() {
    return Collections.emptyList();
  }

  String getName() {
    return name;
  }

  DiceEvalScope getScope() {
    return scope;
  }

  String getVariableName() {
    return getScope().getScopePrefix() + getName();
  }
}
