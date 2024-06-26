package cn.taskeren.gtnn.mod.gt5u.tile;

import cn.taskeren.gtnn.GTNN;
import cn.taskeren.gtnn.mod.gt5u.util.DisassemblerRecipes;
import gregtech.api.enums.SoundResource;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine_GT_Recipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TileEntityDisassembler extends GT_MetaTileEntity_BasicMachine_GT_Recipe {

	public TileEntityDisassembler(int aID, String aName, String aNameRegional, int aTier) {
		super(
			aID,
			aName,
			aNameRegional,
			aTier,
			"Disassembles items into their components",
//			NNRecipe.Disassembler.getRecipeMap(),
			DisassemblerRecipes.DISASSEMBLER_RECIPES,
			1,
			9,
			false,
			SoundResource.NONE,
			SpecialEffects.NONE,
			"ASSEMBLER",
			new Object[]{"ACA", "WHW", "ACA", 'A', X.ROBOT_ARM, 'C', X.CIRCUIT,'W', X.WIRE, 'H', X.HULL}
		);
	}

	@Override
	public void addAdditionalTooltipInformation(ItemStack stack, List<String> tooltip) {
		tooltip.add("§cPresented by GTNH-NO-NERF!");
	}

	@Override
	public ArrayList<String> getSpecialDebugInfo(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer, int aLogLevel, ArrayList<String> aList) {
		// TODO: REMOVE
		getBaseMetaTileEntity().increaseStoredEnergyUnits(10_000_000, true);
		GTNN.logger.info("Currently stored Energy: %d", getBaseMetaTileEntity().getStoredEU());
		return super.getSpecialDebugInfo(aBaseMetaTileEntity, aPlayer, aLogLevel, aList);
	}
}
