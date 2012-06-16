/**
 * Created with IntelliJ IDEA.
 * User: Michael Fazio
 * Date: 6/12/12
 */

/*
 == FIELDS ==
 More Stats
 Basic Stats
 Plate Appearances
 At Bats
 Doubles
 Triples
 Home Runs
 Walks
 Strikeouts
 Batting Average
 Hit By Pitch
 Non-Contact Chances
 Strikeout chance
 Walk Chance
 Strikeout looking chance
 Hit by pitch chance

 Splits
 Basic Stats
 Plate Appearances
 At Bats
 Doubles
 Triples
 Home Runs
 Walks
 Strikeouts
 Batting Average
 Hit By Pitch
 Contact Chances
 Fly ball chance
 Ground ball chance
 Line drive chance
 Fly Ball
 Single
 Double
 Triple
 Home Run
 Ground Ball
 Single
 Double
 Triple
 Home Run
 Line Drive
 Single
 Double
 Triple
 Home Run
 */

function getURLParameter(name) {
    return decodeURI(
        (RegExp(name + '=' + '(.+?)(&|$)').exec(location.search)||[,null])[1]
    );
}

function cleanUpNumber(value) {
    return parseFloat(value.replace(/[^0-9\.]/g, ''));
}

function getPlayerInfo(year) {

    var playerInfo = new Object();

    playerInfo["name"] = $("#info_box").find("h1").text();
    playerInfo["year"] = year;

    return playerInfo;
}

function getTableValues(fields, tablename, year, row) {
    row = typeof row !== 'undefined' ? row : 0;

    var values = new Object();
    var indexTable = "#" + tablename;
    var statTable = "#" + tablename;
    if(year != null) statTable = statTable + "\\." + year;

    if($(indexTable).size() > 0 && $(statTable).size() > 0) {
        $.each(fields, function(index, value) {
            var i = $(indexTable + " th:contains('" + value + "')").first().index() + 1;
            values[value] = cleanUpNumber($(statTable + " td:nth-child(" + i + ")")[row].innerHTML);
        });
    }

    return values;
}

function getContactStatRates(stats, totalAtBats) {

    var rates = new Object();
    var atBats = parseInt(stats["AB"]);
    var hits = parseInt(stats["H"]);
    var doubles = parseInt(stats["2B"]);
    var triples = parseInt(stats["3B"]);
    var homeRuns = parseInt(stats["HR"]);
    var singles = hits - (doubles + triples + homeRuns);
    var outs = atBats - hits;

    rates["contactRate"] = (atBats / totalAtBats) * 100;
    rates["singleRate"] = (singles / atBats) * 100;
    rates["doubleRate"] = (doubles / atBats) * 100;
    rates["tripleRate"] = (triples / atBats) * 100;
    rates["homeRunRate"] = (homeRuns / atBats) * 100;
    rates["outRate"] = (outs / atBats) * 100;

    return rates;

}

function loadStatsFromPage(year) {
    var allValues = new Object();
    var fields = [];

    allValues["playerInfo"] = getPlayerInfo(year);

    fields = ["PA", "AB", "H", "2B", "3B", "HR", "BB", "SO", "BA", "HBP"];
    allValues["basicStats"] = getTableValues(fields, "batting_standard", year);

    fields = ["PA", "AB", "H", "2B", "3B", "HR", "BB", "SO", "BA"]
    var contactStats = new Object();
    contactStats["groundBallRates"] = getTableValues(fields, "traj", null, 0);
    contactStats["flyBallRates"] = getTableValues(fields, "traj", null, 1);
    contactStats["lineDriveRates"] = getTableValues(fields, "traj", null, 2);

    var atBats = 0;
    for(stat in contactStats) {
        atBats += parseInt(contactStats[stat]["AB"]);
    }

    allValues["contactRates"] = new Object();

    for(statType in contactStats) {
        allValues["contactRates"][statType] = getContactStatRates(contactStats[statType], atBats);
    }

    fields = ["SO%", "BB%"];
    allValues["nonContactRates"] = getTableValues(fields, "batting_ratio", year);

    fields = ["L/SO"];
    var tempVal = getTableValues(fields, "batting_pitches", year);
    allValues["nonContactRates"]["L/SO"] = tempVal["L/SO"];

    var PAs = allValues["basicStats"]["PA"];
    var HBPs = allValues["basicStats"]["HBP"];

    allValues["nonContactRates"]["hbpRate"] = (HBPs / PAs) * 100;

    return JSON.stringify(allValues);
}

function loadStats(year) {
    var playerID = $(this).attr("sr_page_id");
    var divID = "sr_js";

    var moreStatsURL = $(location).attr("href").replace(".shtml", "-bat.shtml");
    var splitsURL = "/players/split.cgi?id=" + playerID + "&year=" + year + "&t=b"
    var result;

    if($('#faz').size() === 0) {
        $("#page_content").append("<div id='faz'></div>"),
            $.get(moreStatsURL, function(data) {
                $("#faz").append(data);
                $.get(splitsURL, function(data) {
                    $("#faz").append(data);
                })
            });
    } else {
        console.log(loadStatsFromPage(year));
    }
}

loadStats();