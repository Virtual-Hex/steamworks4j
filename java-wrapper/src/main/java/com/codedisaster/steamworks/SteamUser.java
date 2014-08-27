package com.codedisaster.steamworks;

public class SteamUser {

	private long pointer;

	public SteamUser(long pointer) {
		this.pointer = pointer;
	}

	static void dispose() {
	}

	public SteamID getSteamID() {
		return new SteamID(getSteamID(pointer));
	}

	// @off

	/*JNI
		#include <steam_api.h>
	*/

	static private native long getSteamID(long pointer); /*
		ISteamUser* user = (ISteamUser*) pointer;
		CSteamID steamID = user->GetSteamID();
		return (int64) steamID.ConvertToUint64();
	*/

}